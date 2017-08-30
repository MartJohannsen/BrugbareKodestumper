package Objects;

/**
 * Created by Martin on 01-08-2017.
 */
public class Animal
{
    int heightInCM;
    String name;
    String race;

    public Animal(int heightInCM, String name, String race) {
        this.heightInCM = heightInCM;
        this.name = name;
        this.race = race;
    }

    public int getHeightInCM() {
        return heightInCM;
    }

    public void setHeightInCM(int heightInCM) {
        this.heightInCM = heightInCM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRace()
    {
        return race;
    }

    public void setRace(String race)
    {
        this.race = race;
    }
}
