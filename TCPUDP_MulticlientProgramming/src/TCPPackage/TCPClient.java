package TCPPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Martin on 10-08-2017.
 */
public class TCPClient
{
    public static void main(String[] args) throws Exception
    {
        String sentence;
        String modifiedSentence;
        Scanner scanner;

        // Her sættes de nødvendige socket og port værdier op, så den kan tilkoble servern.

        Socket clientSocket = new Socket("localhost", 8000);

        // Både input- og output stream skal anvendes, så de sættes op her.

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());

        // Brugeren skal taste ind her

        System.out.println("Client is running and ready:    ");

        scanner = new Scanner(System.in);
        sentence = scanner.nextLine();

        // Sætningen sendes afsted til serveren

        outToServer.writeUTF(sentence);

        // Derefter modtager vi sætningen, med store bogstaver

        modifiedSentence = inFromServer.readUTF();

        // Lukker det hele ned efter os, så socket'en ikke står åben på serveren

        System.out.println("From server:    " + modifiedSentence);
        clientSocket.close();
    }
}
