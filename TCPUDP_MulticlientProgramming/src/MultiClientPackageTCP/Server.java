package MultiClientPackageTCP;

/**
 * Created by Martin on 10-08-2017.
 */
public class Server
{
    public static void main(String[] args) throws Exception
    {
        ConnectionStarter.getInstance().run();
    }
}
