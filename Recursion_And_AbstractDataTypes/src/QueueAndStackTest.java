import PriorityPackage.MyPriorityQueue;
import PriorityPackage.Patient;
import StackandQueuePackage.MyQueue;
import StackandQueuePackage.MyStack;

/**
 * Created by Martin on 26-07-2017.
 */
public class QueueAndStackTest
{
    public static void main(String[] args)
    {
        MyStack myStack = new MyStack();
        myStack.insert(5);
        myStack.insert(7);
        myStack.insert(3);
        myStack.insert(6);
        myStack.insert(4);

        System.out.println("Sneak peek of what's to be pulled:  " + myStack.peek());

        int newNum = myStack.pull();

        System.out.println("Number pulled from stack:   " + newNum);

        myStack.insert(48);

        newNum = myStack.pull();

        System.out.println("Number pulled from stack:   " + newNum);


        tenSecondPause();


        System.out.println("\n\n\n");

        MyQueue myQueue = new MyQueue();
        myQueue.insert(5);
        myQueue.insert(7);
        myQueue.insert(3);
        myQueue.insert(6);
        myQueue.insert(4);

        myQueue.printQueue();

        System.out.println("Sneak peek of what's to be pulled:  " + myQueue.peek());

        int numFromQueue = myQueue.pull();

        System.out.println("Number pulled from queue:   " + numFromQueue);

        myQueue.printQueue();
        myQueue.insert(88);
        myQueue.insert(46);
        myQueue.printQueue();

        for(int i =0; i < 3; i++){
            numFromQueue = myQueue.pull();
            System.out.println("Number pulled from queue:   " + numFromQueue);
        }

        myQueue.printQueue();

        tenSecondPause();

        System.out.println("\n\n\n");

        MyPriorityQueue hospital = new MyPriorityQueue();
        Patient johnOne = new Patient("John Doe the First", 3);
        Patient johnTwo = new Patient("John Deer the Second", 6);
        Patient johnThree = new Patient("John Dingo the Third", 4);
        Patient Penny = new Patient("Penny", 7);
        Patient Dede = new Patient("Dede", 11);
        Patient Martin = new Patient("Martin", 10);

        hospital.insert(johnOne);
        hospital.insert(johnTwo);
        hospital.insert(johnThree);
        hospital.insert(Penny);
        hospital.insert(Dede);
        hospital.insert(Martin);

        System.out.println(hospital.listToString());

        Patient currentPatient = (Patient) hospital.pull();

        System.out.println("PriorityPackage.Patient pulled: " + currentPatient.getName());

        currentPatient = (Patient) hospital.pull();

        System.out.println("PriorityPackage.Patient pulled: " + currentPatient.getName());


    }

    public static void tenSecondPause(){
        try{
            Thread.sleep(10000);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
