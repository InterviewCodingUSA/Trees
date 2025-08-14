import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BinTree<Integer> tree = getTree();
        ArrayList<List<Integer>> paths = pathSum3NodeToNodeSumEqualTarget(tree, 3);
        System.out.println("I am here");
    }

    private static ArrayList<List<Integer>> pathSum3NodeToNodeSumEqualTarget(BinTree<Integer> tree, int target){
        ArrayList<ArrayList<Integer>> allPaths = tree.getAllPaths();
        ArrayList<List<Integer>> targetPaths = new ArrayList<>();
        for (ArrayList<Integer> list : allPaths){
            ArrayList<List<Integer>> paths = findSubarraysWithSum(list, target);
            targetPaths.addAll(paths);
        }
        return targetPaths;
    }

    private static ArrayList<List<Integer>> findSubarraysWithSum(ArrayList<Integer> arr, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        // Iterate through all possible starting indices
        for (int i = 0; i < arr.size(); i++) {
            int currentSum = 0;
            // Iterate through all possible ending indices starting from i
            for (int j = i; j < arr.size(); j++) {
                currentSum += arr.get(j);
                // Check if the current sum equals the target
                if (currentSum == target) {
                    List<Integer> test =   arr.subList(i,j+1);
                    result.add(arr.subList(i,j+1));
                }
            }
        }

        return result;
    }


    // Creates and returns a binary tree with a predefined structure
    // The tree is constructed with integer values as follows:
    //
    //                1
    //              /   \
    //             2     3
    //            / \   / \
    //           4   5 6   7
    //          /   /     / \
    //         8   9    10  11
    //                        \
    //                        12
    //
    // Returns: A BinTree<Integer> with the specified structure
    private static BinTree<Integer> getTree() {
        // Initialize a new binary tree
        BinTree<Integer> tree = new BinTree<>();

        // Set the root node with value 1
        tree.root = new Node<>(1);

        // Construct left subtree
        tree.root.left = new Node<>(2);
        tree.root.left.left = new Node<>(4);
        tree.root.left.right = new Node<>(5);
        tree.root.left.left.left = new Node<>(8);
        tree.root.left.right.left = new Node<>(9);

        // Construct right subtree
        tree.root.right = new Node<>(3);
        tree.root.right.left = new Node<>(6);
        tree.root.right.right = new Node<>(7);

        tree.root.right.right.left = new Node<>(10);
        tree.root.right.right.right = new Node<>(11);
        tree.root.right.right.right.right = new Node<>(12);

        // Return the constructed tree
        return tree;
    }
}