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


    public void printLeftView(){
        if(root == null){
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean bPrint = true;

        while(!queue.isEmpty()){
            Node<T> node = queue.remove();

            if(node != null){
                if(bPrint){
                    System.out.println(node.data);
                    bPrint = false;
                }
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
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                bPrint = true;
            }
        }
    }
}
