// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {
    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }

    public int height(){
        return height(root);
    }

    public int height(Node<T> node){
        if(node == null){
            return 0;
        }
        return 1 +  Math.max( height(node.left), height(node.right)) ;
    }


    public int diameter(){
        return diameter(root);
    }
    private int diameter(Node<T> node){
        if(node == null){
            return 0;
        }

        // We should not have to calculate height everytime.
        // Basically we can have a property in Node class which contains height of the node.
        // We can ger the height in one go instead of recursively calling it.
        // For now this is ok for interview purposes.
        int lHeight = height(node.left);
        int rHeight = height(node.right);

        int lDiameter = height(node.left);
        int rDiameter = height(node.right);

        return  Math.max(lHeight + rHeight + 1 , Math.max(lDiameter, rDiameter));

    }


}
