
import java.util.ArrayList;

/**
 * Created by Martin on 27-07-2017.
 */
public class MyGraph
{
    private ArrayList<MyEdge> listOfRoutes;
    private ArrayList<MyVertex> listOfAirPorts;

    public MyGraph(){
        this.listOfAirPorts = new ArrayList<>();
        this.listOfRoutes = new ArrayList<>();
    }

    public void addAirPort(String cityName){
        MyVertex airport = new MyVertex(cityName);
        this.listOfAirPorts.add(airport);
        airport.setID(listOfAirPorts.size() - 1);
        System.out.println(": Added airport to flight network:  " + airport.getName());
    }

    public void addAirPort(MyVertex newAirport){
        listOfAirPorts.add(newAirport);
        newAirport.setID(listOfAirPorts.size() - 1);

    }

    public void addRouteAndAirports(MyVertex pointA, MyVertex pointB, int distance){
        listOfAirPorts.add(pointA);
        pointA.setID(listOfAirPorts.size() - 1);
        listOfAirPorts.add(pointB);
        pointB.setID(listOfAirPorts.size() - 1);

        MyEdge newRoute = new MyEdge(listOfRoutes.size(), distance, pointA, pointB);

        listOfRoutes.add(newRoute);
        pointA.addConnection(pointB);
        pointB.addConnection(pointA);

        System.out.println(": Added route from - " + pointA.getName() + " - " + pointB.getName() + ": to flight network");
    }

    //********************************************************************************************************************

    //DEN VIL IKKE GODTAGE INDEXOF DET NAVN MAN INDSÆTTER, DETTE BLIVER TIL -1 OG SKABER EN EXCEPTION

    public void addRoute(String pointAName, String pointBName, int distance){
        int pointASpot = 0;
        int pointBSpot = 0;
        for(MyVertex vertex : listOfAirPorts){
            if(vertex.getName().equals(pointAName)){
                pointASpot = vertex.getID();
            }
            if(vertex.getName().equals(pointBName)){
                pointBSpot = vertex.getID();
            }

        }

        MyVertex pointA = listOfAirPorts.get(pointASpot); // DENNE DRILLER!!!
        MyVertex pointB = listOfAirPorts.get(pointBSpot);

        pointA.addConnection(pointB);
        pointB.addConnection(pointA);

        System.out.println(pointA.getName());
        System.out.println(pointB.getName());
        //listOfAirPorts.add(pointA);
        //pointA.setID(listOfAirPorts.size());
        //listOfAirPorts.add(pointB);
        //pointB.setID(listOfAirPorts.size());

        MyEdge newRoute = new MyEdge(listOfRoutes.size(), distance, listOfAirPorts.get(pointASpot), listOfAirPorts.get(pointBSpot));

        listOfRoutes.add(newRoute);

        System.out.println(": Added route from - " + pointA.getName() + " - " + pointB.getName() + ": to flight network");
    }

    public void printFlightNetwork(){
        String airports = "";
        String connections = "";
        for(MyVertex vertex : listOfAirPorts){
            airports += vertex.getID() + ": " + vertex.getName() + ", ";
        }
        for(MyEdge edge : listOfRoutes){
            connections += edge.getAirportA().getName() + " : " + edge.getAirportB().getName() + " : Length = " + edge.getWeight() + "\n";
        }

        System.out.println(airports);
        System.out.println(connections);
    }

    public ArrayList<MyEdge> getListOfRoutes()
    {
        return listOfRoutes;
    }

    public ArrayList<MyVertex> getListOfAirPorts()
    {
        return listOfAirPorts;
    }
}
