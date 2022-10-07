/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 */

/**
 * This class is used to solve the problem by using dfs and bst rules.
 * We know that the lowest common ancestor will be the node where the two values split.
 * This means that one value will be >= that value and the other will be <= that value
 * The node under examination needs to be compared to the two values of the nodes
 * If the two nodes are less than the current node, we know the LCA will be on the right side of the tree, so we recursively search that
 * If the two nodes are greater than the current node, we know the LCA will be on the left side, so we recursively search that side
 * Once we find a value that is either equal to one of the nodes or splits the two nodes, we return that value
 */
public class LowestCommonAncestorOfBST
{
    /**
     * This method is used to find the lowest common ancestor of two node values
     * @param node is the node being examined
     * @param p is one of the node values
     * @param q is one of the node values
     * @return the lowest common ancestor of the two node values
     */
    public static int lowestCommonAncestor(Node<Integer> node, int p, int q) {
        if ((node.value <= p && node.value >= q) || (node.value >= p && node.value <= q)) return node.value;
        else if (node.value < p) return lowestCommonAncestor(node.right, p, q);
        else return lowestCommonAncestor(node.left, p, q);
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        StaticIntegerBinaryTree testTree1 = new StaticIntegerBinaryTree("6 2 0 x x 4 3 x x 5 x x 8 7 x x 9 x x");
        System.out.println(lowestCommonAncestor(testTree1.root, 2, 8));
        StaticIntegerBinaryTree testTree2 = new StaticIntegerBinaryTree("6 2 0 x x 4 3 x x 5 x x 8 7 x x 9 x x");
        System.out.println(lowestCommonAncestor(testTree2.root, 2, 4));
        StaticIntegerBinaryTree testTree3 = new StaticIntegerBinaryTree("2 1 x x x");
        System.out.println(lowestCommonAncestor(testTree3.root, 2, 1));
    }
}
