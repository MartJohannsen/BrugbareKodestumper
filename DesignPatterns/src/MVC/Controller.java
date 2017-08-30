package MVC;

/**
 * Created by Martin on 12-07-2017.
 */
public class Controller
{
    private static Controller instance = null;

    private Controller(){
    }

    public static Controller getInstance()
    {
        if(instance == null){
            return instance = new Controller();
        }
        else
        {
            return instance;
        }
    }

    public int fromControllerToView(int num){
        View.getInstance().printResult(num);

        return num;
    }

    public int fromViewToModel(int num){
        int result = Model.getInstance().recieveNumber(num);

        return result;
    }
}
