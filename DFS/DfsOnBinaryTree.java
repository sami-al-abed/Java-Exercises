/**
 * This is a dfs algorithm used to find a node containing a certain value in a binary tree
 */
public class DfsOnBinaryTree
{
    /**
     * This method is used to find a node in a binary tree containing a target value
     * @param root the current node being examined
     * @param target the target value we are trying to find
     * @return the node containing the target value
     */
    public static Node<Integer> dfs(Node<Integer> root, int target) {
        // if root is null, return null
        if (root == null) return null;

        // if the root contains the value return the root
        if (root.value == target) return root;

        // Check left of tree, if the value is on the left, return the left node with that value
        Node<Integer> left = dfs(root.left, target);
        if (left != null) return left;

        // Check the right of the tree, if the value is on the right, return the right node with that value, if not return null
        return dfs(root.right, target);
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        StaticIntegerBinaryTree testTree = new StaticIntegerBinaryTree("5 4 3 10 x x x 8 x x 6 x x"); // create tree using pre-order traversal through string

        // run pre order traversal on the subtree using the target node as the root
        Traversal.preOrderTraversal(testTree.root);
        System.out.println("\n");
        Traversal.preOrderTraversal(dfs(testTree.root, 4));
    }
}
