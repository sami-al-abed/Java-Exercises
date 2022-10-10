/**
 * This class contains traversal algorithms used to read values of trees
 */
public class Traversal
{
    /**
     * This method prints values of a tree using in-order traversal
     * @param root is the root of the tree
     */
    public static void inOrderTraversal(Node<Integer> root) {
        if (root != null) {
            inOrderTraversal(root.left); // check left
            System.out.println(root.value); // do itself
            inOrderTraversal(root.right); // check right
        }
    }

    /**
     * This method prints values of a tree using pre-order traversal
     * @param root is the root of the tree
     */
    public static void preOrderTraversal(Node<Integer> root) {
        if (root != null) {
            System.out.println(root.value); // do itself
            preOrderTraversal(root.left); // check left
            preOrderTraversal(root.right); // check right
        }
    }

    /**
     * This method prints values of a tree using post-order traversal
     * @param root is the root of the tree
     */
    public static void postOrderTraversal(Node<Integer> root) {
        if (root != null) {
            postOrderTraversal(root.left); // check left
            postOrderTraversal(root.right); // check right
            System.out.println(root.value); // do itself
        }
    }

    /**
     * This method prints values of a non-binary tree
     * @param root is the root of the tree
     */
    public static void nonBinaryTreeTraversal(NoBinaryNode<Integer> root) {
        if (root != null) {
            System.out.println(root.value);
            for ( int i = 0; i < root.children.size(); i++) {
                nonBinaryTreeTraversal(root.children.get(i));
            }
        }
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        StaticIntegerBinaryTree testTree = new StaticIntegerBinaryTree("5 4 3 x x 8 x x 6 x x"); // create tree using pre-order traversal through string
        StaticIntegerNonBinaryTree testTree1 = new StaticIntegerNonBinaryTree("1 3 2 1 5 0 3 0 4 0");

        preOrderTraversal(testTree.root);
        System.out.println("\n");
        postOrderTraversal(testTree.root);
        System.out.println("\n");
        inOrderTraversal(testTree.root);
        System.out.println("\n");
        nonBinaryTreeTraversal(testTree1.root);
    }
}
