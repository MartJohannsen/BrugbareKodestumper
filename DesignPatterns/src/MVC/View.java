package MVC;

import java.util.Scanner;

/**
 * Created by Martin on 12-07-2017.
 */
public class View
{
    Scanner scanner;

    public static View instance = null;

    private View() {
    }

    public static View getInstance()
    {
        if(instance == null){
            return instance = new View();
        }
        else{
            return instance;
        }
    }

    public void startPage(){
        scanner = new Scanner(System.in);

        System.out.println("Enter any number and 7 will be added");

        int number = scanner.nextInt();

        int result = sendNumbertoController(number);



    }

    public void printResult(int num){
        System.out.println(num);
    }

    public int sendNumbertoController(int num){
        int result = Controller.getInstance().fromViewToModel(num);

        return result;
    }
}
