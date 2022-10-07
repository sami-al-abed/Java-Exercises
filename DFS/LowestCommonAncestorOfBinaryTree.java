/**
 * Lowest common ancestor (LCA) of two nodes v and w in a tree is the lowest (i.e. deepest) node that has both v and w as descendants.
 * We also define each node to be a descendant of itself (so if v has a direct connection from w, w is the lowest common ancestor).
 *
 * Given two nodes of a binary tree, find their lowest common ancestor.
 */

import java.util.Objects;

/**
 * This problem is solved by using dfs to first find the nodes and then backtrack to find the lowest common ancestor
 * This is done by first checking if the node is null.
 * If the node is not null, we check the value of the node to see if we found node1 or node2
 * If we don't we search the left and right subtree for the two nodes
 * Once we find the two nodes, we backtrack until they meet at a common ancestor.
 * We know we have found the common ancestor when both the left and right searches return either node1 or node2
 * This means that it is the lowest parent node of both nodes.
 * We then return this node back to each recursive call of the function until we return to the root node where it is the output
 */
public class LowestCommonAncestorOfBinaryTree
{
    /**
     * Function that returns the lowest common ancestor of two nodes
     * @param root is the node being examined
     * @param node1 is one of the nodes we are looking for the ancestor of
     * @param node2 is one of the nodes we are looking for the ancestor of
     * @return the lowest common ancestor or null
     */
    private static Node<Integer> lowestCommonAncestor(Node<Integer> root, Node<Integer> node1, Node<Integer> node2) {
        if (root == null) return null;
        if (Objects.equals(root.value, node1.value) || Objects.equals(root.value, node2.value)) return root;

        Node<Integer> left = lowestCommonAncestor(root.left, node1, node2);
        Node<Integer> right = lowestCommonAncestor(root.right, node1, node2);

        if (left != null && right != null) return root;
        else if (left == null) return right;
        else return left;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        Node<Integer> node1;
        Node<Integer> node2;
        Node<Integer> lca;

        StaticIntegerBinaryTree testTree1 = new StaticIntegerBinaryTree("6 4 3 x x 5 x x 8 x x");
        node1 = new Node<>(4);
        node2 = new Node<>(8);
        lca = lowestCommonAncestor(testTree1.root, node1, node2);
        if (lca != null) System.out.println(lca.value);
        else System.out.println("nodes not in tree");

        StaticIntegerBinaryTree testTree2 = new StaticIntegerBinaryTree("6 4 3 x x 5 x x 8 x x");
        node1 = new Node<>(4);
        node2 = new Node<>(6);
        lca = lowestCommonAncestor(testTree2.root, node1, node2);
        if (lca != null) System.out.println(lca.value);
        else System.out.println("nodes not in tree");

        StaticIntegerBinaryTree testTree3 = new StaticIntegerBinaryTree("6 4 3 x x 5 x x 8 x x");
        node1 = new Node<>(3);
        node2 = new Node<>(5);
        lca = lowestCommonAncestor(testTree3.root, node1, node2);
        if (lca != null) System.out.println(lca.value);
        else System.out.println("nodes not in tree");

        StaticIntegerBinaryTree testTree4 = new StaticIntegerBinaryTree("x");
        node1 = new Node<>(3);
        node2 = new Node<>(2);
        lca = lowestCommonAncestor(testTree4.root, node1, node2);
        if (lca != null) System.out.println(lca.value);
        else System.out.println("nodes not in tree");
    }
}
