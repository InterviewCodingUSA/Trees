import java.util.HashMap;

// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {
    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }

    public void printTopLevelView(){
        if(root == null){
            return;
        }
        BoxValue<Integer> minValue = new BoxValue<>(0);
        BoxValue<Integer> maxValue = new BoxValue<>(0);

        HashMap<Integer,Node<T>> map = new HashMap<>();

        printTopView(root, 0, map, minValue, maxValue);

        for(int i = minValue.data ; i <= maxValue.data; i ++){
            System.out.printf(map.get(i).data + ", ");
        }
        System.out.println();

    }

    private void printTopView( Node<T> node,
                               Integer distance,
                               HashMap<Integer, Node<T>> map,
                               BoxValue<Integer> minValue,
                               BoxValue<Integer> maxValue){
        if(node != null){
            // adding value to the hash map
            if(!map.containsKey(distance)){
                map.put(distance, node);
            }
            if(distance < minValue.data){
                minValue.data = distance;
            }
            if(distance > maxValue.data){
                maxValue.data = distance;
            }
            printTopView(node.left, distance - 1, map, minValue, maxValue);
            printTopView(node.right, distance + 1, map, minValue, maxValue);

        }
    }
}
