package TreePackage;

import java.util.ArrayList;

/**
 * Created by Martin on 06-08-2017.
 */
public class Tree
{
    private Node root;
    private ArrayList<Node> tree = new ArrayList<>();

    public void addNode(Node node, int desiredRoot){
        boolean foundFlag = false;
        if(root != null){
            for(Node oldNode : tree){
                if(oldNode.getValue() == desiredRoot){
                    oldNode.addChildNode(node);
                    tree.add(node);
                }
            }
        }
        else{
            root = node;
        }
    }

    public void addNode(int nodeValue, int desiredRoot){
        Node node = new Node(nodeValue);
        boolean foundFlag = false;

        for(int i = 0; i < tree.size(); i++){
            Node oldNode = tree.get(i);
            int oldNodeVal = oldNode.getValue();
            if(oldNodeVal == desiredRoot){
                oldNode.addChildNode(node);
                tree.add(node);
                foundFlag = true;
            }
            else{
                System.out.println("not the one, keep looking");
            }
        }

        if (root == null && tree.size() == 0){
            root = node;
        }
    }

    public void addRoot(int value){
        Node node = instantiateNode(value);
        root = node;
        tree.add(root);
    }

    public Node instantiateNode(int value){
        Node node = new Node(value);
        return node;
    }

    public void printTreeContent(){
        String completeTreeString = "{";

        for (Node node : tree){
            System.out.println();
            System.out.print(node.getValue() + ": Contains:   " );
            for (int i = 0; i < node.childNodes.size(); i++){
                System.out.print(node.childNodes.get(i).getValue()+" : ");
            }
            completeTreeString += node.getValue() + ", ";
        }

        completeTreeString += " }";
        System.out.println();
        System.out.println("The complete list of tree contents: " + completeTreeString);
    }



}
