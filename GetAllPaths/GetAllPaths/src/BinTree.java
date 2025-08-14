import java.util.ArrayList;

// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {
    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }
    public ArrayList<ArrayList<T>> getAllPaths(){
        ArrayList<T> list = new ArrayList<>();
        ArrayList<ArrayList<T>> fullList = new ArrayList<>();

        getAllPaths(root, list,fullList, 0);
        return fullList;
    }

    private void getAllPaths(Node<T> node, ArrayList<T> list, ArrayList<ArrayList<T>> fullList, int index){
        if(node != null){
            list.add(index, node.data);
            if(node.left == null && node.right == null){
                ArrayList<T> path = new ArrayList<>();
                for(int i = 0 ; i < index + 1; i ++) {
                    path.add(i, list.get(i));
                }
                fullList.add(path);
            }
            getAllPaths(node.left, list, fullList, index +1);
            getAllPaths(node.right, list, fullList, index +1);
        }
    }

}
