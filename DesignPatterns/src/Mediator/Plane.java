package Mediator;

/**
 * Created by Martin on 12-07-2017.
 */
public class Plane
{
    private String name;
    private String model;
    private String airService;

    public Plane(String name, String model, String airService)
    {
        this.name = name;
        this.model = model;
        this.airService = airService;
    }

    public void sendMessage(String message){
        broadcastToAll(message);
    }

    public void broadcastToAll(String message){

        ControlTower.getInstance().recieveMessage(message);
    }

    public void recieveMessage(String message){
        System.out.println(getAirService() + " : " + getModel() + " : " + getName() + " has recieved message:   " + message);
    }

    public String getName()
    {
        return name;
    }

    public String getModel()
    {
        return model;
    }

    public String getAirService()
    {
        return airService;
    }
}
