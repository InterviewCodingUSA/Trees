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

    public void levelOrder(){
        if(root == null){
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(queue.size() != 0){
            Node<T> node = queue.remove();

            if(node != null){
                System.out.printf(node.data + " , ");
                if(node.left!= null){
                    queue.add(node.left);
                }
                if(node.right!= null){
                    queue.add(node.right);
                }
            }
            else{
                // We have reached to a new level
                System.out.println();
                if(queue.size() == 0){
                    break;
                }
                queue.add(null);
            }
        }
    }

    public void deleteLeafNode(T data){
        root = deleteLeafNode(root, data);

    }

    private  Node<T> deleteLeafNode(Node<T> node, T data){
        // Base case
        if (node == null) {
            return null;
        }

        // 1. Visit the left children
        node.left = deleteLeafNode(node.left, data);

        // 2. Visit the right children
        node.right = deleteLeafNode(node.right, data);

        // 3. Check if the current node is a leaf node and its value equals target
        if (node.left == null && node.right == null && node.data.compareTo(data) == 0) {
            // Delete the node by returning null to the parent, effectively disconnecting it
            return null;
        }

        // Keep it untouched otherwise
        return node;
    }
}
