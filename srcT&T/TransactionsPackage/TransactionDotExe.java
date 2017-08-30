import java.sql.*;
import java.util.Scanner;

public class TransactionDotExe
{
    public static String userName = "root";
    public static String superSecretPassWord = "Tr4nsF0rm3r5";

    public static void main(String[] args) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;

        try {
            // Først oprettes forbindelsen til databasen
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", userName, superSecretPassWord);

            // Derefter slukkes der for autocommit, således at den ikke selv ruller ind.
            myConn.setAutoCommit(false);

            // Print den forhenværende løn
            System.out.println("Løn før: \n");
            showSalaries(myConn, "HR");
            showSalaries(myConn, "Engineering");

            // Transaction Step 1: At slette alle i HR afdelingen, lav statement i conn. og kør den nedenstående SQL sekvens
            myStmt = myConn.createStatement();
            myStmt.executeUpdate("delete from employees where department='HR'");

            // Transaction Step 2: Giv alle i engineering lønforhøjelse
            myStmt.executeUpdate("update employees set salary=300000 where department='Engineering'");

            System.out.println("\n>> Transaktionen er nu klar.\n");

            // Ask user if it is okay to save
            boolean ok = askUserIfOkToSave();

            if (ok) {
                // store in database
                myConn.commit();
                System.out.println("\n>> Transaction COMMITTED.\n");
            } else {
                // discard
                myConn.rollback();
                System.out.println("\n>> Transaction ROLLED BACK.\n");
            }

            // Show salaries AFTER
            System.out.println("Salaries AFTER\n");
            showSalaries(myConn, "HR");
            showSalaries(myConn, "Engineering");

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            close(myConn, myStmt, null);
        }
    }

    /**
     * Prompts the user. Return true if they enter "yes", false otherwise
     *
     * @return
     */
    private static boolean askUserIfOkToSave() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Is it okay to save?  yes/no: ");
        String input = scanner.nextLine();

        scanner.close();

        return input.equalsIgnoreCase("yes");
    }

    private static void showSalaries(Connection myConn, String theDepartment) throws SQLException {
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        System.out.println("Show Salaries for Department: " + theDepartment);

        try {
            // Prepare statement
            myStmt = myConn.prepareStatement("select * from employees where department=?"); // Prepared statement der gør klar til at "erstatte" '?' med theDepartment

            myStmt.setString(1, theDepartment); // Her indsættes the department på "?"'s plads.

            // Execute SQL query
            myRs = myStmt.executeQuery(); // Kør sql statements

            // Process result set
            while (myRs.next()) { // Rs.next() fanger hver række (altså personer)
                String lastName = myRs.getString("last_name"); // getString fanger her lastname værdien hos den gældende person
                String firstName = myRs.getString("first_name"); // -||-
                double salary = myRs.getDouble("salary"); // -||- dog med double istedet
                String department = myRs.getString("department"); // -||-

                System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, department, salary); // printformatted med placeholdere
            }

            System.out.println();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            close(myStmt, myRs); // Luk ned for connection og resultset
        }

    }

    // Denne metode lukker ned for de forskellige connections, statements og resultsets den fodres.
    private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {
            myStmt.close();
        }

        if (myConn != null) {
            myConn.close();
        }
    }
    // Overload af den forhenværende funktion.
    private static void close(Statement myStmt, ResultSet myRs)
            throws SQLException {

        close(null, myStmt, myRs);
    }
}
