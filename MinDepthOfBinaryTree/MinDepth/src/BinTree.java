// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {
    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }

    // Returns the minimum depth of the tree (shortest path from root to leaf)
    public int minDepth() {
        return minDepth(root);
    }

    // Helper method for recursive minimum depth calculation
    private int minDepth(Node<T> node) {
        // Base case: empty tree has depth 0
        if (node == null) {
            return 0;
        }

        // If leaf node (no children), return 1
        if (node.left == null && node.right == null) {
            return 1;
        }

        // If only one child exists, return depth of that subtree
        if (node.left == null) {
            return minDepth(node.right) + 1;
        }
        if (node.right == null) {
            return minDepth(node.left) + 1;
        }

        // If both children exist, return minimum of left and right subtrees
        return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
    }

    // Returns the maximum depth of the tree (longest path from root to leaf)
    public int maxDepth() {
        return maxDepth(root);
    }

    // Helper method for recursive maximum depth calculation
    private int maxDepth(Node<T> node) {
        // Base case: empty tree has depth 0
        if (node == null) {
            return 0;
        }

        // Recursively calculate depths of left and right subtrees
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        // Return maximum of left and right depths, plus 1 for current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
