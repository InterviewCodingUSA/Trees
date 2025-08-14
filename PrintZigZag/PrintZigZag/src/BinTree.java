import java.util.LinkedList;
import java.util.Queue;
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

    public void printZigZag(){
        if(root == null){
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean bPrint = true;
        Stack<Node<T>> stack = new Stack<>();

        while(!queue.isEmpty()){
            Node<T> node = queue.remove();

            if(node != null){
                if(bPrint){
                    System.out.printf(node.data + " , ");
                }else{
                    stack.push(node);
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
                while(!stack.empty()){
                    System.out.printf(stack.pop().data + ", ");
                }
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                bPrint = !bPrint;
            }
        }
    }
}
