package UDPpackage;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Martin on 10-08-2017.
 */
public class UDPServer
{
    public static void main(String[] args) throws Exception
    {
        int serverPort = 8600;
        DatagramSocket serverSocket = new DatagramSocket(serverPort);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while(true){
            //Der gøres klar til at modtage en pakke

            System.out.println("Server kører, nu afventes et datagram / pakke");

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            // beskeden fra pakken printes

            String sentence = new String(receivePacket.getData());
            System.out.println("Received:   " + sentence);

            // Så fanges ip'en og porten fra den modtagede pakke

            InetAddress IPAdress = receivePacket.getAddress();

            int port = receivePacket.getPort();

            // Så oversættes beskeden til stort, samt fortolkes i bytes

            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();

            // En ny pakke oprettes med den nye besked, samt længde og de nødvendige adresse info.
            // Pakken sendes

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, port);
            serverSocket.send(sendPacket);

        }
    }
}
