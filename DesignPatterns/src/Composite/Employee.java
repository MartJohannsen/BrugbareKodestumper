package Composite;

import java.util.ArrayList;

/**
 * Created by Martin on 10-07-2017.
 */
public class Employee
{
    public String title;

    public double payCheck;
    public ArrayList<Employee> listOfEmployees = new ArrayList<Employee>();

    public Employee(String title, double payCheck)
    {
        this.title = title;
        this.payCheck = payCheck;
    }

    public void addEmployee(Employee employee){
        listOfEmployees.add(employee);
    }

    public void giveRaise(double percentage){
        this.payCheck = payCheck/100 * (100 + percentage);
    }

    public void giveEmployeesRaise(double percentage){
        for(Employee employee : listOfEmployees){
            employee.giveRaise(percentage);
        }
    }

    public void printEmployeeList(){
        for(Employee employee : listOfEmployees){
            System.out.println(employee.title + ", " + employee.getPayCheck());
        }
    }

    public double departmentCost(){
        double price = getPayCheck();

        for(Employee employee : listOfEmployees){
            price += employee.departmentCost();
        }

        return price;
    }

    public double getPayCheck()
    {
        return payCheck;
    }

}
