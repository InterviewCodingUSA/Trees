// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {

    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }

    private void longestZigZag(Node<T> node, boolean goLeft, int steps, BoxValue value) {
        if (node == null) {
            return;
        }
        value.value = Math.max(value.value, steps);
        if (goLeft) {
            longestZigZag(node.left, false, steps + 1, value);
            longestZigZag(node.right, true, 1, value);
        } else {
            longestZigZag(node.left, false, 1, value);
            longestZigZag(node.right, true, steps + 1, value);
        }
    }

    public int longestZigZag() {
        BoxValue value = new BoxValue(0);
        longestZigZag(root, true, 0, value);
        return value.value;
    }
}
