import java.util.*;

/**
 * Created by Martin on 13-08-2017.
 */
public class MyDijkstra
{
    private final List<MyVertex> vertices;
    private final List<MyEdge> edges;
    private Set<MyVertex> settledVertices;
    private Set<MyVertex> unSettledVertices;
    private Map<MyVertex, MyVertex> predecessors;
    private Map<MyVertex, Integer> distance;

    public MyDijkstra(MyGraph myGraph){
        this.vertices = new ArrayList<MyVertex>();
        vertices.addAll(myGraph.getListOfAirPorts());// Verticesne ER lufthavne
        this.edges = new ArrayList<MyEdge>(myGraph.getListOfRoutes());
    }

    public void execute(MyVertex source){
        // Instanciering
        settledVertices = new HashSet<MyVertex>(); // Vertices i denne er blevet betragtet, i forhold til hvilke der har laveste weight
        unSettledVertices = new HashSet<MyVertex>(); // Vertices i denne, er endnu ikke blevet betragtet. Dijkstra slutter ikke før dene er tom.
        distance = new HashMap<MyVertex, Integer>(); // Indeholder vertices, og distancen til disse.
        predecessors = new HashMap<MyVertex, MyVertex>(); // Indeholder forgangne vertices

        // Tilføjer "kilden" som det første besøgte sted. Sørger for at whileløkken længere ned kører!
        distance.put(source, 0);
        unSettledVertices.add(source);

        while(unSettledVertices.size() > 0){
            MyVertex node = getMinimum(unSettledVertices); // Den mindste nabo vertex skal findes her
            settledVertices.add(node); // Herefter tilføjes denne til de undersøgte vertices.
            unSettledVertices.remove(node); // Fjernes så fra unsettled, da den er undersøgt.
            findMinimalDistances(node); // Finder korteste distance blandt naboer
        }
    }

    private void findMinimalDistances(MyVertex node){
        List<MyVertex> adjacentNodes = getNeighbours(node); // I denne metode skal alle naboer undersøges, for korteste distance.
        for(MyVertex target : adjacentNodes){
            if(getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)){
                distance.put(target, getShortestDistance(node) + getDistance(node,target)); // Hvis den korteste distance fra target, er større end (den korteste distance til node og distance mellem node og target) -
                predecessors.put(target, node);// tilføj target, korteste distance plusset med distancen mellem node og target. Derefter tilføj target og node til predecessors.
                unSettledVertices.add(target); // Tilføj target til unsettledvertices.
            }
        }
    }

    private int getDistance(MyVertex node, MyVertex target){
        for(MyEdge edge : edges){
            if(edge.getAirportA().equals(node) && edge.getAirportB().equals(target)){
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Burde ikke ske..");
    }

    private List<MyVertex> getNeighbours(MyVertex node){
        List<MyVertex> neighbors = new ArrayList<MyVertex>(); // I denne metode findes alle naboer til en given vertex.
        for(MyEdge edge : edges){
            if(edge.getAirportA().equals(node) && !isSettled(edge.getAirportB())){
                neighbors.add(edge.getAirportB()); // Her undersøges edges, hvis airport a matcher, og airport b ikke er settled, tilføje til nabo.
            }
        }
        return neighbors;
    }

    private MyVertex getMinimum(Set<MyVertex> vertices){
        // Gennemgår de forskellige vertices der hører til kilden. Returnerer tilsidst den med mindst vægt.

        MyVertex minimum = null;
        for(MyVertex vertex : vertices){
            if (minimum == null){
                minimum = vertex; // Er minimum tom, skal den have noget at starte på.
            }
            else{
                if(getShortestDistance(vertex) < getShortestDistance(minimum)){
                    minimum = vertex; // Hvis den korteste distance er til det undersøgte vertex, så ændres minimum til denne.
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(MyVertex vertex){
        return settledVertices.contains(vertex);
    }

    private int getShortestDistance(MyVertex destination){
        Integer d = distance.get(destination); // fang distancen til destinationen, i distance mappet
        if(d == null){
            return Integer.MAX_VALUE;
        }
        else
        {
            return d;
        }
    }

    public LinkedList<MyVertex> getPath(MyVertex target){
        LinkedList<MyVertex> path = new LinkedList<MyVertex>();
        MyVertex step = target;
        // Tjekker om steppet eksisterer
        if(predecessors.get(step) == null){
            return null;
        }
        path.add(step); // hvis det ikke eksisterer i predecessors, lægges det ind i path
        while(predecessors.get(step) != null){
            step = predecessors.get(step); // Går predecessors igennem, hvis step eksisterer lægges de i path
            path.add(step);

        }
        // Sæt i korrekte orden
        Collections.reverse(path);
        return path;

    }
}
