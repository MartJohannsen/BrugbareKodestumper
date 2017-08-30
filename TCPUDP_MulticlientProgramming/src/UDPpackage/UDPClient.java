package UDPpackage;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Martin on 10-08-2017.
 */
public class UDPClient
{
    public static void main(String[] args) throws Exception
    {
        int port = 8600;

        // (Ignorér kommentar) BufferedReader parser IKKE en string, og læser derimod kun en sekvens af karakterer
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();

        // Så fanges ipadressen fra inetadress og de nødvendige arrays klargøres

        InetAddress IPAdress = InetAddress.getByName("localhost");

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        // Vi modtager en besked fra brugeren, denne oversættes til bytes.

        System.out.println("Client running, please type in message to server:   \n");

        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();// Selve oversættelsen

        // På pakken noteres indhold, indholdet's længde, adresse og port.
        // Herefter sendes pakken

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, port);
        clientSocket.send(sendPacket);

        // Klargørelse af modtagelse, for herefter at modtage pakke fra server.

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        // En ny streng, med den oversættede tekst fra modtaget pakke instantieres.
        // Der printes og lukkes for socket.

        String modifiedSentence = new String(receivePacket.getData());

        System.out.println("From Server:    " + modifiedSentence);
        clientSocket.close();

    }
}
