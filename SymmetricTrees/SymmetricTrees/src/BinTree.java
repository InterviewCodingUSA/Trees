// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {
    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }

    // Determines whether this tree is a mirror of itself around its center,
    // i.e. the left subtree is a mirror reflection of the right subtree.
    public boolean isSymmetric(){
        return isMirror(root, root);
    }

    // Two nodes are mirrors of each other when their values match and each
    // node's left child mirrors the other node's right child (and vice versa).
    private boolean isMirror(Node<T> node1, Node<T> node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        if(!node1.data.equals(node2.data)){
            return false;
        }

        return  isMirror(node1.left, node2.right) &&
                isMirror(node1.right, node2.left);
    }

}
