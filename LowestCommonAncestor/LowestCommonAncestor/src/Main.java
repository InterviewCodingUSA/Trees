//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BinTree<Integer> tree = getTree();
        Node<Integer> node1 = tree.root.right.right.left; // Node 10
        Node<Integer> node2 = tree.root.right.right.right.right; // Node 12
        Node<Integer> lca = LCA(tree.root, node1, node2);
        System.out.println(lca.data);


    }

    public static Node<Integer> LCA(Node<Integer> node, Node<Integer> node1, Node<Integer> node2){
        if(node == null){
            return null;
        }
        if(node == node1 || node == node2){
            // current node is the node which we are looking for
            // The First or second node is direct descendant of the First or second node
            return node;
        }
        // Look for ancestor in left and right subtrees
        Node<Integer> leftLCA = LCA(node.left, node1, node2);
        Node<Integer> rightLCA = LCA(node.right, node1, node2);

        if(leftLCA != null && rightLCA != null){
            // Both the nodes are present that means at this node
            // One node is on one side and another on other side
            // return the node
            return node;
        }

        return leftLCA != null ? leftLCA : rightLCA;

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