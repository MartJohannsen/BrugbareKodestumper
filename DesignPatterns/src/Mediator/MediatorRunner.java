package Mediator;

/**
 * Created by Martin on 12-07-2017.
 */
public class MediatorRunner
{
    public static void main(String[] args)
    {
        ControlTower controlTower = ControlTower.getInstance();

        Plane Airbus = new Plane("Buzzkill", "Airbus A380", "HansaAir");
        Plane Boeing = new Plane("Noisey", "Boeing 747", "DeltaAir");
        Plane Johannsen = new Plane("Biggie", "Hercules AC-130", "Military aircraft");

        controlTower.getAirSpace().add(Airbus);
        controlTower.getAirSpace().add(Boeing);
        controlTower.getAirSpace().add(Johannsen);

        Airbus.sendMessage("Hello all, what's up? - Buzzkill");

        Johannsen.sendMessage("Requesting EVAC, CPH Airport - Biggie");



    }
}
