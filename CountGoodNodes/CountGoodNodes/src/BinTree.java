// Binary tree class that manages a tree structure of nodes
// Uses generic type T that must be comparable for ordering
public class BinTree<T extends Comparable<T>> {
    private int numGoodNodes =0;
    // Root node of the binary tree
    public Node<T> root;

    // Default constructor initializing an empty tree
    public BinTree() {
        this.root = null;
    }

    public int countGoodNodes(){
        countGoodNodes(root, (Integer)root.data);
        return numGoodNodes;
    }

    private void countGoodNodes(Node<T> node, int maxSoFar) {
        if (maxSoFar <= (Integer)node.data) {
            numGoodNodes++;
        }

        if (node.right != null) {
            countGoodNodes(node.right, Math.max((Integer)node.data, maxSoFar));
        }

        if (node.left != null) {
            countGoodNodes(node.left, Math.max((Integer)node.data, maxSoFar));
        }
    }
}
