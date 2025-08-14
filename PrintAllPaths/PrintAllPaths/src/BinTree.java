import java.util.ArrayList;

// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {
    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }

    public void printAllPaths(){
        ArrayList<T> list = new ArrayList<>();
        printAllPaths(root, list, 0);
    }
    private void printAllPaths(Node<T> node, ArrayList<T> list, int index){
        if(node != null){
            list.add(index, node.data);
            if(node.left == null && node.right == null){
                for(int i = 0 ; i < index + 1; i ++) {
                    System.out.printf(list.get(i) + " -> ");
                }
                System.out.println("Null");
            }
            printAllPaths(node.left, list, index +1);
            printAllPaths(node.right, list, index +1);

        }
    }
}
