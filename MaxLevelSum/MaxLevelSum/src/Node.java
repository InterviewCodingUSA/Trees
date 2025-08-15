// Node class representing a single node in the binary tree
// Generic type T allows for flexible data storage
public class Node<T> {
    // Data stored in the node
    public T data;
    // Reference to the left child node
    public Node<T> left;
    // Reference to the right child node
    public Node<T> right;

    // Constructor to initialize a node with given data
    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}