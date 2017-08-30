package BinarySearchTreePackage;

/**
 * Created by Martin on 06-08-2017.
 */
public class MyBinaryNode
{
    private int value;
    private MyBinaryNode leftElement;
    private MyBinaryNode rightElement;

    public MyBinaryNode(int value)
    {
        this.value = value;
    }

    public MyBinaryNode(int value, MyBinaryNode leftElement, MyBinaryNode rightElement)
    {
        this.value = value;
        this.leftElement = leftElement;
        this.rightElement = rightElement;
    }

    public int getValue() {return value;}

    public void setValue(int value) {this.value = value;}

    public MyBinaryNode getLeftElement() {return leftElement;}

    public void setLeftElement(MyBinaryNode leftElement) {this.leftElement = leftElement;}

    public MyBinaryNode getRightElement() {return rightElement;}

    public void setRightElement(MyBinaryNode rightElement) {this.rightElement = rightElement;}
}
