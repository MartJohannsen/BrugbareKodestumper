package MVC;

/**
 * Created by Martin on 12-07-2017.
 */
public class Model
{
    public static Model instance = null;

    private Model(){
    }

    public static Model getInstance()
    {
        if(instance == null){
            return instance = new Model();
        }
        else{
            return instance;
        }
    }

    public int recieveNumber(int number){
        int result = addSeven(number);

        sendProcessedNumber(result);

        return result;
    }

    public int addSeven(int number){
        int result = 7;

        result = result + number;

        return result;
    }

    public int sendProcessedNumber(int number){
        Controller.getInstance().fromControllerToView(number);

        return number;
    }




}
