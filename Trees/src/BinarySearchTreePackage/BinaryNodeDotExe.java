package BinarySearchTreePackage;

/**
 * Created by Martin on 07-08-2017.
 */
public class BinaryNodeDotExe
{
    public static void main(String[] args)
    {
        MyBinaryTree binaryTree = new MyBinaryTree();
        binaryTree.addNode(50);
        binaryTree.addNode(45);
        binaryTree.addNode(43);
        binaryTree.addNode(58);
        binaryTree.addNode(59);
        binaryTree.addNode(47);
        binaryTree.addNode(48);
        binaryTree.addNode(46);

        System.out.println("Displaying in order:    ");
        binaryTree.displayInOrder(binaryTree.rootNode);
        System.out.println("\n\nDisplaying pre order:   ");
        binaryTree.displayPreOrder(binaryTree.rootNode);
        System.out.println("\n\nDisplaying post order   ");
        binaryTree.displayPostOrder(binaryTree.rootNode);

        System.out.println("\n");

        binaryTree.printSideways(binaryTree.rootNode, 0);

        MyBinaryNode foundNode = binaryTree.search(46, binaryTree.rootNode);

        System.out.println(foundNode.getValue() + "found by findNode function");
    }

}
