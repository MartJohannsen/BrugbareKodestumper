package PriorityPackage;

/**
 * Created by Martin on 27-07-2017.
 */
public class Patient
{
    public String name;
    public int urgencyFactor;

    public Patient(String name, int urgencyFactor)
    {
        this.name = name;
        this.urgencyFactor = urgencyFactor;
    }

    public String getName()
    {
        return name;
    }

    public int getUrgencyFactor()
    {
        return urgencyFactor;
    }

}
