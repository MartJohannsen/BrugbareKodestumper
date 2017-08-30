package IteratorDemo;

/**
 * Created by Martin on 14-07-2017.
 */
public class IterationExampleDotExe
{
    public static void main(String[] args)
    {
        NameRepository nameRepository = new NameRepository();

        Iteration iterator = nameRepository.getIterator(); // Instanterer en klasse der implementerer Iteration interfacet

        while(iterator.hasNext()){
            String name = (String)iterator.next(); // Iteration interfacet returnerer et object, derfor caster vi
            System.out.println("Name :  " + name);
        }
    }

}
