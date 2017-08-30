package BoxExample;

/**
 * Created by Martin on 03-08-2017.
 */
public class BoxExampleDotExe
{
    public static void main(String[] args)
    {
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();

        integerBox.add(8000);
        stringBox.add("What's in the box?");

        System.out.println("Integer box:    " + integerBox.get());
        System.out.println("String box:     " + stringBox.get());
    }
}
