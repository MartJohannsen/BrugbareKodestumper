import java.util.ArrayList;

/**
 * Created by Martin on 27-07-2017.
 *
 * Vertex fungerer som et punkt i en graph.
 *
 **/
public class MyVertex
{
    private int ID;
    private String name;
    ArrayList<MyVertex> connections;

    public MyVertex(int ID, String name)
    {
        this.ID = ID;
        this.name = name;
        this.connections = new ArrayList<MyVertex>();
    }

    public MyVertex(String name)
    {
        this.name = name;
        this.connections = new ArrayList<MyVertex>();
    }

    public void addConnection(MyVertex connection){
        this.connections.add(connection);
    }




    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<MyVertex> getConnections()
    {
        return connections;
    }

    public void setConnections(ArrayList<MyVertex> connections)
    {
        this.connections = connections;
    }
}
