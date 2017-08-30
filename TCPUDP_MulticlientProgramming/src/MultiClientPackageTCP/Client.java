package MultiClientPackageTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Martin on 10-08-2017.
 */
public class Client
{
    public static void main(String[] args) throws Exception
    {
        String sentence;
        String modifiedSentence;
        int clientPort = 8000;
        Scanner scanner;


        Socket clientSocket = new Socket("localhost", clientPort);

        //Datastreams klargøres ved instantiering

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());

        System.out.println("Client kører");

        while(true){
            //Client indtaster besked
            System.out.println("Indtast en besked her:  ");
            scanner = new Scanner(System.in);
            sentence = scanner.nextLine();

            // Her sendes beskeden til serveren.

            outToServer.writeUTF(sentence);
            System.out.println("Data er sendt");

            // Her modtages den nye besked og printes hos brugeren

            modifiedSentence = inFromServer.readUTF();
            System.out.println("Fra server: " + modifiedSentence);

        }
    }
}
