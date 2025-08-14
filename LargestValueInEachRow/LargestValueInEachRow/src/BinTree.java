import java.util.LinkedList;
import java.util.Queue;

// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {
    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }

    public void maxNodeAtEachLevel() {
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        Node<T> maxNode = null;

        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();

            if (node != null) {
                if(maxNode != null){
                    maxNode = maxNode.data.compareTo(node.data) > 0 ? maxNode : node;
                }else{
                    maxNode = node;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                // We have reached to a new level
                assert maxNode != null;
                System.out.println(maxNode.data);
                maxNode = null;
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            }
        }
    }

    public void minNodeAtEachLevel() {
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        Node<T> minNode = null;

        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();

            if (node != null) {
                if(minNode != null){
                    minNode = minNode.data.compareTo(node.data) < 0 ? minNode : node;
                }else{
                    minNode = node;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                // We have reached to a new level
                assert minNode != null;
                System.out.println(minNode.data);
                minNode = null;
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            }
        }
    }
}
