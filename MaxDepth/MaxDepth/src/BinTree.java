// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {
    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }

    // Returns the maximum depth of the binary tree
    // The depth is the length of the longest path from the root to a leaf
    // Returns: the maximum depth as an integer
    public int maxDepth() {
        return maxDepth(root);
    }

    // Helper method to calculate the maximum depth recursively
    // Parameters: node - the current node being processed
    // Returns: the maximum depth of the subtree rooted at the given node
    private int maxDepth(Node<T> node) {
        if (node == null) {
            return 0;
        }
        // Recursively compute the depth of left and right subtrees Basically Post order
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        // Return the maximum of left and right depths, plus 1 for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
