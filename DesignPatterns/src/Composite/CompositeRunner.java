package Composite;

/**
 * Created by Martin on 10-07-2017.
 */
public class CompositeRunner
{
    public static void main(String[] args)
    {
        Employee bossEmployee = new Employee("CEO", 35000);

        bossEmployee.addEmployee(new Employee("SalesManager", 20000));
        bossEmployee.addEmployee(new Employee("ChiefArchitect", 15000));

        System.out.println("Boss salary:    " + bossEmployee.getPayCheck());

        bossEmployee.giveRaise(3);

        System.out.println("Boss salary after raise:    " + bossEmployee.getPayCheck());

        bossEmployee.printEmployeeList();

        System.out.println("\nGive the bosses employess a raise of 1%\n");
        bossEmployee.giveEmployeesRaise(1);

        bossEmployee.printEmployeeList();

        System.out.println("Price for the boss, and his minions:    " + bossEmployee.departmentCost());
    }
}

