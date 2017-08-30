package TCPPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Martin on 10-08-2017.
 */
public class TCPServer
{
    public static void main(String[] args) throws Exception
    {
        String clientSentence;
        String capitalizedSentence;

        ServerSocket welcomeSocket = new ServerSocket(8000);
        System.out.println("Server started. ");

        while(true){
            // Først tages der imod brugeren

            Socket connectionSocket = welcomeSocket.accept();
            InetAddress inetAddress = connectionSocket.getInetAddress();

            // Her printes brugerens oplysninger

            System.out.println("Client host name is:    " + inetAddress.getHostName());
            System.out.println("Client IP address is:   " + inetAddress.getHostAddress());

            // Herefter opsættes en datastream fra klient til server

            DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());

            // ... Og også en fra server til klient

            DataOutputStream outToClient;
            outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            // Så modtages selve den besked som klienten har sendt

            clientSentence = inFromClient.readUTF();

            System.out.println("Recieved:   " + clientSentence);

            // , og så oversættes den til capitalized.

            capitalizedSentence = clientSentence.toUpperCase() + '\n';

            // Til sidst sendes den tilbage til selve klienten.

            outToClient.writeUTF(capitalizedSentence);
        }


    }
}
