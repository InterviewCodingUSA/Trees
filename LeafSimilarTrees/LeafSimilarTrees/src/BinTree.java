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

    public ArrayList<T> getAllLeaves(){
        ArrayList<T> list = new ArrayList<>();
        getAllLeaves(root, list);
        return list;
    }
    private void getAllLeaves(Node<T> node, ArrayList<T> list){
        if(node != null){
            // Leaf node
            if(node.left == null && node.right == null){
                list.addLast(node.data);
            }
            getAllLeaves(node.left, list);
            getAllLeaves(node.right, list);

        }
    }
}
