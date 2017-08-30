import com.sun.istack.internal.NotNull;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Martin on 27-07-2017.
 */
public class MyGraphDotExe
{
    public static void main(String[] args)
    {
        // Grafen hedder flightroutes, denne holder styr på airports og connections
        // Vertices hedder airports, disse er noder
        // Edges hedder connections, disse indeholder vægt og styr på enderne.

        MyGraph flightRoutes = new MyGraph();

        pause(500);

        MyVertex london = new MyVertex("London");
        MyVertex beijing = new MyVertex("Beijing");

        pause(500);


        flightRoutes.addRouteAndAirports(london, beijing, 1200);


        pause(500);

        flightRoutes.addAirPort("Kuala Lumpur");
        flightRoutes.addAirPort("Luang Prabang");
        flightRoutes.addAirPort("Leicester");
        flightRoutes.addAirPort("NewYork");
        flightRoutes.addAirPort("Dubai");
        flightRoutes.addAirPort("Oslo");
        flightRoutes.addAirPort("Copenhagen");

        pause(500);

        // Tilføjelse af ruter, bemærk at ruten mellem dubai og kbh er længere end en omvej

        flightRoutes.addRoute("London", "Leicester", 825);
        flightRoutes.addRoute("Dubai", "Copenhagen", 3200);
        flightRoutes.addRoute("Copenhagen", "Luang Prabang", 800);
        flightRoutes.addRoute("London", "Dubai", 600);
        flightRoutes.addRoute("Dubai", "Luang Prabang", 50);
        flightRoutes.addRoute("Luang Prabang", "Dubai", 50);
        flightRoutes.addRoute("Luang Prabang", "Oslo", 50);
        flightRoutes.addRoute("Oslo", "Copenhagen", 50);
        flightRoutes.addRoute("London", "Copenhagen", 751);

        pause(500);

        flightRoutes.printFlightNetwork();

        // Dijkstra - Bevæg dig ud i det, hvis du tør
        /*
        pause(2500);

        // Først "kalder" vi airports og ruter, for noder og edges, for overskuelighedens skyld.

        List<MyVertex> nodes = flightRoutes.getListOfAirPorts();
        List<MyEdge> edges = flightRoutes.getListOfRoutes();

        MyDijkstra dijkstra = new MyDijkstra(flightRoutes); // Dijkstra instancieres og hertil anvendes flightroutes grafen
        dijkstra.execute(nodes.get(0)); // Herfra eksekverer vi Dijkstras algoritme, fra det første indeks i lufthavnslisten, London.
        LinkedList<MyVertex> path = dijkstra.getPath(nodes.get(nodes.size()-1));

        for(MyVertex vertex : path){
            System.out.println(vertex.getName());
        }
        */
    }

    public static void pause(int num){
        try{
            Thread.sleep(num);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
