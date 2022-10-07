/**
 * Given a binary tree, invert it and return the new value.
 * You may invert it in-place.
 *
 * To "invert" a binary tree, switch the left subtree and the right subtree, and invert them both. Inverting an empty tree does nothing.
 */

/**
 * This class solves the problem by using dfs.
 * The class's invert function takes a root of a tree as an argument.
 * It first checks if the node is null and if not it creates a new node containing the same value with the right and left child nodes switched.
 * When switching the left and right nodes, the invert function is called recursively to invert the subtree on its left and right as well.
 */
public class InvertBinaryTree
{
    /**
     * This method is used to invert a binary tree
     * @param root the node being examined
     * @return the new node with inverted left and right children nodes
     */
    public static Node<Integer> invert(Node<Integer> root) {
        if (root == null) return null;
        return new Node<>(root.value, invert(root.right), invert(root.left));
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        StaticIntegerBinaryTree testTree1 = new StaticIntegerBinaryTree("1 2 4 x x 5 6 x x x 3 x x");
        testTree1.root = invert(testTree1.root);
        Traversal.preOrderTraversal(testTree1.root);
        System.out.println("\n");

        StaticIntegerBinaryTree testTree2 = new StaticIntegerBinaryTree("1 2 5 x x x 3 4 6 x x 7 x x x");
        testTree2.root = invert(testTree2.root);
        Traversal.preOrderTraversal(testTree2.root);
        System.out.println("\n");

        StaticIntegerBinaryTree testTree3 = new StaticIntegerBinaryTree("1 2 7 x x 5 x x 3 4 x x 6 x x");
        testTree3.root = invert(testTree3.root);
        Traversal.preOrderTraversal(testTree3.root);
        System.out.println("\n");

        StaticIntegerBinaryTree testTree4 = new StaticIntegerBinaryTree("1 2 x 3 x 4 5 x x x x");
        testTree4.root = invert(testTree4.root);
        Traversal.preOrderTraversal(testTree4.root);
        System.out.println("\n");

        StaticIntegerBinaryTree testTree5 = new StaticIntegerBinaryTree("6 11 x 27 17 x x 23 x x 10 12 x x 13 x 14 x x");
        testTree5.root = invert(testTree5.root);
        Traversal.preOrderTraversal(testTree5.root);
        System.out.println("\n");
    }
}
