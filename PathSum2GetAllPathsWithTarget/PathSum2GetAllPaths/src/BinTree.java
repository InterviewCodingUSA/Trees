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

    public ArrayList<ArrayList<T>> pathSum2GetAllPaths(Integer target) {
        ArrayList<T> list = new ArrayList<>();
        ArrayList<ArrayList<T>> fullList = new ArrayList<>();

        pathSum2GetAllPaths(root, list, fullList, 0, target);
        return fullList;
    }

    private void pathSum2GetAllPaths(Node<T> node, ArrayList<T> list, ArrayList<ArrayList<T>> fullList, int index, Integer target) {
        if (node != null) {
            list.add(index, node.data);
            if (node.left == null && node.right == null) {
                ArrayList<T> path = new ArrayList<>();
                int sum = 0;
                for (int i = 0; i < index + 1; i++) {
                    path.add(i, list.get(i));
                    sum += (Integer)list.get(i);
                }
                if(sum == target) {
                    fullList.add(path);
                }
            }
            pathSum2GetAllPaths(node.left, list, fullList, index + 1, target);
            pathSum2GetAllPaths(node.right, list, fullList, index + 1, target);
        }
    }
}