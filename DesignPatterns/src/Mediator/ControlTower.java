package Mediator;

import java.util.ArrayList;

/**
 * Created by Martin on 12-07-2017.
 */
public class ControlTower
{
    private ArrayList<Plane> airSpace = new ArrayList<Plane>();

    private static ControlTower instance = null;

    private ControlTower()
    {
    }

     public static ControlTower getInstance()
    {
        if(instance == null){
            return instance = new ControlTower();
        }
        else{
            return instance;
        }

    }

    public ArrayList<Plane> getAirSpace()
    {
        return airSpace;
    }

    public void recieveMessage(String message){
        System.out.println("\nIncoming message:   " + message + "\n\n");
        try{
            Thread.sleep(1000);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        broadcastMessage(message);
    }

    public void broadcastMessage(String message){
        for(Plane plane : getAirSpace()){
            sendMessage(message, plane);
        }
    }

    public void sendMessage(String message, Plane plane){
        plane.recieveMessage(message);
    }


}
