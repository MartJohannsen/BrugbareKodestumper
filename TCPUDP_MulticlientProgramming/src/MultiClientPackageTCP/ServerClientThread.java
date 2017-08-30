package MultiClientPackageTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Martin on 10-08-2017.
 */
public class ServerClientThread extends Thread
{
    private Socket socket;
    private int port;
    private String clientSentence;
    private String capitalizedSentence;
    private InetAddress inetAddress;

    public ServerClientThread(Socket socket){
        try{
            this.socket = socket;
            this.port = socket.getPort();
            this.inetAddress = socket.getInetAddress();
            System.out.println("Tråd sat igang");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        try{
            System.out.println("Klient host name er: " + inetAddress.getHostName());
            System.out.println("Klient Ip adresse er:" + inetAddress.getHostAddress());

            while(true){
                // inputstream instantieres med socket's inputstream

                DataInputStream inFromClient = new DataInputStream(socket.getInputStream());

                //det samme for output

                DataOutputStream outToClient;
                outToClient = new DataOutputStream(socket.getOutputStream());

                //her læses klientens besked

                clientSentence = inFromClient.readUTF();

                System.out.println("Modtaget:   " + clientSentence);

                // her oversættes og tilbagesendes den nye besked

                capitalizedSentence = clientSentence.toUpperCase() + '\n';
                System.out.println();
                outToClient.writeUTF(capitalizedSentence);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
