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

    public int maxLevelSum(){
        if(root == null){
            return 0;

        }
        int maxLevel = 0;
        int level = 0;
        Integer sum = 0;
        Integer maxSum = 0;

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node<T> node = queue.remove();
            if(node != null){
                sum += (Integer) node.data;
                if(node.left!= null){
                    queue.add(node.left);
                }
                if(node.right!= null){
                    queue.add(node.right);
                }
            }
            else{
                // We have reached to a new level
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                if(maxSum < sum){
                    maxLevel = level;
                    maxSum = sum;
                }
                level++;
                sum =0;
            }
        }
        return maxLevel;
    }

}
