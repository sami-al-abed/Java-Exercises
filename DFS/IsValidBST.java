/**
 * A binary search tree is a binary tree with the property that for any node
 * The value of this node is greater than any node in its left subtree and less than any node's value in its right subtree.
 * In other words, an inorder traversal of a binary search tree yields a list of values that is monotonically increasing (strictly increasing).
 *
 * Given a binary tree, determine whether it is a binary search tree.
 */

/**
 * This class solves the problem by using dfs to determine if a binary tree is a binary search tree
 * Knowing that a binary search tree is one that is sorted so that all values on the left will be less than the current node and all values on the right will be greater than
 * we can determine whether a tree is a binary search tree by looking at each node and having available the max and min possible values that node can contain.
 * The node is first compared to the highest possible max and lowest possible min based on the previous node in the tree.
 * If the value meets the criteria, the left node is checked with the min value staying the same and the max value equaling the current nodes value
 * The right node is also checked with the min value being the current value of the node and the max value staying the same
 * This is repeated until a null node is found, which is a valid binary search tree, and the tree backtracks to check that each subtree was found to be part of a valid BST
 */
public class IsValidBST
{
    /**
     * This function uses dfs to compare the current nodes values to a specified max and min
     * it then searches its left and right nodes to find if there are any invalid nodes
     * The range on the left is (min - root.value)
     * The range on the right is (root.value - max)
     * @param root the node being examined
     * @param min the min value that the node value needs to be greater than
     * @param max the max value that the node value needs to be less than
     * @return if the subtree is a binary search tree
     */
    public static boolean dfs(Node<Integer> root, int min, int max) {
        if (root == null) return true;
        if (root.value >= max || root.value <= min) return false;
        return dfs(root.left, min, root.value) && dfs(root.right, root.value, max);
    }

    /**
     * This function is used to call the dfs function that searches the tree and then returns its value
     * @param root is the root of the tree to be searched
     * @return if the tree is a binary search tree
     */
    public static boolean isValidBST(Node<Integer> root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        StaticIntegerBinaryTree testTree1 = new StaticIntegerBinaryTree("6 4 3 x x 5 x x 8 x x");
        System.out.println(isValidBST(testTree1.root));
        StaticIntegerBinaryTree testTree2 = new StaticIntegerBinaryTree("6 4 3 x x 8 x x 8 x x");
        System.out.println(isValidBST(testTree2.root));
        StaticIntegerBinaryTree testTree3 = new StaticIntegerBinaryTree("1 2 x x 3 x x");
        System.out.println(isValidBST(testTree3.root));
        StaticIntegerBinaryTree testTree4 = new StaticIntegerBinaryTree("x");
        System.out.println(isValidBST(testTree4.root));
        StaticIntegerBinaryTree testTree5 = new StaticIntegerBinaryTree("3 2 1 x x x 4 x 5 x x");
        System.out.println(isValidBST(testTree5.root));
    }
}
