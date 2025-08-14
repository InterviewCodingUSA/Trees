import java.util.Stack;

// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {
    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }

    // Performs a depth-first search to find a node with the specified data recursively
    // Prints a message if the data is found or not found
    // Parameters: data - the value to search for in the tree
    public void DFS(T data) {
        if (DFS(root, data)) {
            System.out.println("Node with data " + data + " found in the tree.");
        } else {
            System.out.println("Node with data " + data + " not found in the tree.");
        }
    }

    // Helper method for depth-first search
    // Recursively searches the tree for a node with the specified data
    // Parameters: node - the current node being processed
    //             data - the value to search for
    // Returns: true if the data is found, false otherwise
    private boolean DFS(Node<T> node, T data) {
        if (node == null) {
            return false;
        }
        if (node.data.compareTo(data) == 0) {
            return true;
        }
        return DFS(node.left, data) || DFS(node.right, data);
    }

    // DFS using a stack this mimics the recursive call just adds the value to a stack.
    // Parameters: data - the value to search for in the tree
    public void DFSIterative(T data) {
        if (root == null) {
            System.out.println("Node with data " + data + " not found in the tree.");
            return;
        }

        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();

            if (current.data.compareTo(data) == 0) {
                System.out.println("Node with data " + data + " found in the tree.");
                return;
            }

            // Push right child first (so left will be processed first due to stack's LIFO)
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        System.out.println("Node with data " + data + " not found in the tree.");
    }
}

