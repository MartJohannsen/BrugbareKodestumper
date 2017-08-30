package BinarySearchTreePackage;

import jdk.nashorn.internal.ir.BinaryNode;

/**
 * Created by Martin on 06-08-2017.
 */
public class MyBinaryTree
{
    public MyBinaryNode rootNode;

    public MyBinaryTree() {}

    public void addNode(int id){

        MyBinaryNode newNode = new MyBinaryNode(id);
        if(rootNode == null){
            rootNode = newNode;
            return;
        }

        MyBinaryNode current = rootNode;
        MyBinaryNode parent = null;

        while (true){
            parent = current;

            if(id < current.getValue()){
                current = current.getLeftElement();

                if(current == null){
                    parent.setLeftElement(newNode);
                    return;
                }
            }
            else{
                 current = current.getRightElement();
                 if(current == null){
                     parent.setRightElement(newNode);
                     return;
                 }
            }
        }
    }

    public void displayInOrder(MyBinaryNode root){
        if(root != null){
            displayInOrder(root.getLeftElement());
            System.out.print(" " + root.getValue()); // Fanger først alle left elements, derefter alle deres respektive right elements.
            displayInOrder(root.getRightElement()); // (Også disses left elements!)
        }
    }

    public void displayPreOrder(MyBinaryNode root){
        if(root != null){
            System.out.print(" " + root.getValue());
            displayPreOrder(root.getLeftElement()); // Fanger først roden, alle dens venstre elementer og så alle deres højre
            displayPreOrder(root.getRightElement());
        }
    }

    public void displayPostOrder(MyBinaryNode root){
        if(root != null){
            displayPostOrder(root.getLeftElement());
            displayPostOrder(root.getRightElement()); // Fanger først alle venstre eleenter, derefter alle højre og anvender tail recursion til at printe.
            System.out.print(" " + root.getValue());
        }
    }

    public void printSideways(MyBinaryNode root, int level){
        if(root != null){
            printSideways(root.getRightElement(), level + 1);
            for(int i = 0; i < level; i++){
                System.out.print("   ");
            }
            System.out.println(root.getValue());
            printSideways(root.getLeftElement(), level + 1);
        }
    }

    // Denne søge metode søger vha. preorder
    public MyBinaryNode search(int num, MyBinaryNode node){
        if(node != null){
            if(node.getValue()== num){
                return node;
            } else {
                MyBinaryNode foundNode = search(num, node.getLeftElement());
                if(foundNode == null) {
                    foundNode = search(num, node.getRightElement());
                }
                return foundNode;
            }
        }
        else {
            return null;
        }
    }

}
