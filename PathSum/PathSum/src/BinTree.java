// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {
    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }

    // Checks if there exists a root-to-leaf path in the tree with the given sum
    // Parameters: sum - the target sum to find along a path
    // Returns: true if a path with the given sum exists, false otherwise
    public boolean hasPathSum(Integer sum) {
        return hasPathSum(root, sum);
    }

    // Helper method to recursively check for a path with the given sum
    // Parameters: node - the current node being processed
    //             sum - the remaining sum to achieve
    // Returns: true if a path from the current node to a leaf has the given sum, false otherwise
    private boolean hasPathSum(Node<T> node, Integer sum) {
        // Base case: if node is null, no valid path exists
        if (node == null) {
            return false;
        }
        // If it's a leaf node, check if the remaining sum equals the node's data
        if (node.left == null && node.right == null) {
            return sum.equals(node.data);
        }
        // Recursively check left and right subtrees with the remaining sum
        return hasPathSum(node.left, sum - (Integer)node.data) || hasPathSum(node.right, sum - (Integer)node.data);
    }

}
