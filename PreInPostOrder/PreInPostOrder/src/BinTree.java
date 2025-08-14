// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {
    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }
    // Performs a pre-order traversal of the binary tree
    // Prints nodes in the order: root, left subtree, right subtree
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    // Helper method for pre-order traversal
    // Recursively visits the current node, then its left and right children
    // Parameters: node - the current node being processed
    private void preOrder(Node<T> node) {
        if (node != null) {
            System.out.printf(node.data + ", ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Performs an in-order traversal of the binary tree
    // Prints nodes in the order: left subtree, root, right subtree
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    // Helper method for in-order traversal
    // Recursively visits the left child, current node, then right child
    // Parameters: node - the current node being processed
    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.printf(node.data + ", ");
            inOrder(node.right);
        }
    }

    // Performs a post-order traversal of the binary tree
    // Prints nodes in the order: left subtree, right subtree, root
    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    // Helper method for post-order traversal
    // Recursively visits the left and right children, then the current node
    // Parameters: node - the current node being processed
    private void postOrder(Node<T> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.printf(node.data + ", ");
        }
    }
}

