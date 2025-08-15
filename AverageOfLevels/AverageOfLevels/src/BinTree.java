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

    public void printAverages(){
        if(root == null){
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int totalSum = 0;
        int numNodes = 0;
        while(!queue.isEmpty()){
            Node<T> node = queue.remove();

            if(node != null){
                numNodes ++;
                totalSum += (Integer) node.data;
                if(node.left!= null){
                    queue.add(node.left);
                }
                if(node.right!= null){
                    queue.add(node.right);
                }
            }
            else{
                float average = (float)((float)totalSum/(float)numNodes);
                // We have reached to a new level
                System.out.println("Average = " + average);
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                totalSum = 0;
                numNodes = 0;
            }
        }
    }
}
