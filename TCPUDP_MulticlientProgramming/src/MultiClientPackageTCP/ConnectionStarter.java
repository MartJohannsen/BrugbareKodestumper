package MultiClientPackageTCP;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Martin on 10-08-2017.
 */
public class ConnectionStarter extends Thread
{

    // IGNORER START
    private static ConnectionStarter instance = null;

    private ConnectionStarter(){}

    public static ConnectionStarter getInstance(){
        if(instance == null){
            return instance = new ConnectionStarter();
        }
        else{
            return instance;
        }
    }

    // IGNORER SLUT

    public int port = 8000; // Den port som vores software anvender
    public ServerSocket welcomeSocket; // Den socket der sættes op til indkommende klienter

    @Override
    public void run()
    {
        try{
            // socket instanieres og gøres klar med port
            welcomeSocket = new ServerSocket(port);
            System.out.println("Server kører");

            while(true){
                //når en bruger går på socket, accepteres denne
                System.out.println("Venter på bruger");
                Socket connectionSocket;
                connectionSocket = welcomeSocket.accept();

                // Her instantieres nye serverklienttråde.
                //Disse tråde sættes igang, så de individuelt kan kommunikere med hver deres klient.
                // Hver klient har altså sin egen tråd på serveren.

                ServerClientThread serverClientThread = new ServerClientThread(connectionSocket);

                serverClientThread.start();
                System.out.println("Ny tråd startet:    " + connectionSocket.getInetAddress());
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
