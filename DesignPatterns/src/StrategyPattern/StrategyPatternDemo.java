package StrategyPattern;

/**
 * Created by Martin on 09-07-2017.
 *
 * defines a family of algorithms,
 * encapsulates each algorithm, and
 * makes the algorithms interchangeable within that family.
 *
 * behavioural software design pattern
 * Select an algorithm at runtime
 *
 * Eksempel: Hvis en kundes tilstand ændrer sig, f.eks. i løbet af en tilbudsuge
 * så kan man skjule den ændrede logik med strategy pattern. F.eks. hvis kunden er firma eller privat.
 *
 *
 */
public class StrategyPatternDemo
{
    public static void main(String[] args)
    {
        Context context = new Context(new OperationAdd());

        System.out.println(context.executeStrategy(5, 7));

        context = new Context(new OperationMultiply());

        System.out.println(context.executeStrategy(5, 7));

        context = new Context(new OperationSubtract());

        System.out.println(context.executeStrategy(5, 7));

    }
}
