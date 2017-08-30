import TreePackage.Tree;

/**
 * Created by Martin on 06-08-2017.
 */
public class TreesDotExe
{
    public static void main(String[] args)
    {
        Tree tree = new Tree();

        // Roden
        tree.addRoot(35);

        // Noder
        tree.addNode(22, 35);
        tree.addNode(68, 22);
        tree.addNode(48, 35);
        tree.addNode(222, 48);
        tree.addNode(15, 48);
        tree.addNode(36, 48);

        // Tegn min struktur på en tavle :-)
        tree.printTreeContent();

    }
}
