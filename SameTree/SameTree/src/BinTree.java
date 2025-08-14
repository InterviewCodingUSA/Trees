// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {
    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }

    // Function for checking of all the nodes in both the trees are same Basically same nodes.
    // We can put this in the main or in this class, I believe this should be a main function.

    public boolean areSameTrees(Node<T> node1, Node<T> node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }

        return node1.data == node2.data &&
                areSameTrees(node1.left, node2.left) &&
                areSameTrees(node1.right, node2.right);
    }

}
