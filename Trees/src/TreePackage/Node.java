package TreePackage;

import java.util.ArrayList;

/**
 * Created by Martin on 06-08-2017.
 */
public class Node
{
    private int value;
    ArrayList<Node> childNodes;

    public Node(int value)
    {
        this.value = value;
        childNodes = new ArrayList<>();
    }

    public void addChildNode(Node node){
        childNodes.add(node);
        System.out.println(getValue() + " : Has added child node :  " + node.getValue());
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
}
