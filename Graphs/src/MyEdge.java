/**
 * Created by Martin on 27-07-2017.
 */
public class MyEdge
{
    private int ID;
    private int weight;
    private MyVertex airportA;
    private MyVertex airportB;

    public MyEdge(int ID, int weight, MyVertex airportA, MyVertex airportB)
    {
        this.ID = ID;
        this.weight = weight;
        this.airportA = airportA;
        this.airportB = airportB;
    }

    public MyEdge(int ID)
    {
        this.ID = ID;
    }

    public void addConnections(){
        airportA.addConnection(airportB);
        airportB.addConnection(airportA);
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public MyVertex getAirportA()
    {
        return airportA;
    }

    public void setAirportA(MyVertex airportA)
    {
        this.airportA = airportA;
    }

    public MyVertex getAirportB()
    {
        return airportB;
    }

    public void setAirportB(MyVertex airportB)
    {
        this.airportB = airportB;
    }
}
