/**
 * A balanced binary tree is defined as a tree such that either it is an empty tree, or all its subtree are balanced and has a height difference of at most 1.
 *
 * In that case, given a binary tree, determine if it's balanced.
 */

/**
 * This class is used to solve this problem by using dfs to compare the height of left and right subtrees to determine if the tree is balanced
 * This is done by using dfs to go all the way to the bottom of the tree until a leaf node is found and then backtracking nodes to compare the left and right heights of each node.
 * If the left height and right height differ by 2 or more, the tree is imbalanced and rather than returning the height the function returns -1
 * If a node's left or right height is returned to be -1, that means a child node was found to contain an unbalanced subtree and the function returns -1
 * If the node's children are found to all be balanced, the max height of the left and right is incremented by 1 and that value is returned
 * Once the function has backtracked back to the root of the tree, either the height of the tree or -1 is returned to check whether the tree is balanced or not
 * The function calling the dfs function then checks if the value returned is -1, if it is it returns false and if not it returns true
 */
public class IsItABalancedTree
{
    /**
     * This function is used to find the max height of each subtree using dfs
     * The height of the left and right subtree are compared and if there is a difference greater than 1 between the two, then an imbalance has been found
     * The imbalance alert takes the form as returning -1, and this value will be sent all the way up to the root and returned to inform that the tree is not balanced
     * @param root the node being examined
     * @return either the max height of a balanced tree or -1
     */
    public static int dfs(Node<Integer> root) {
        if (root == null) return 0;

        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * This function is used to call the dfs function used to get the height of each subtree and check if that function found an unbalanced subtree
     * @param root is the root of the tree
     * @return true if the dfs function returns the max height of the tree and false if the function returns -1
     */
    public static boolean isBalanced(Node<Integer> root) {
        return dfs(root) != -1;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        StaticIntegerBinaryTree testTree1 = new StaticIntegerBinaryTree("1 2 4 x 7 x x 5 x x 3 x 6 x x");
        System.out.println(isBalanced(testTree1.root));
        StaticIntegerBinaryTree testTree2 = new StaticIntegerBinaryTree("1 2 4 x 7 x x 5 x x 3 x 6 8 x x x");
        System.out.println(isBalanced(testTree2.root));
        StaticIntegerBinaryTree testTree3 = new StaticIntegerBinaryTree("1 2 3 x x 4 x 6 x x 5 x x");
        System.out.println(isBalanced(testTree3.root));
        StaticIntegerBinaryTree testTree4 = new StaticIntegerBinaryTree("1 2 3 x x 4 x 6 x x 5 x 7 x x");
        System.out.println(isBalanced(testTree4.root));
        StaticIntegerBinaryTree testTree5 = new StaticIntegerBinaryTree("1 2 3 x x 4 x x 5 6 x 7 x x x");
        System.out.println(isBalanced(testTree5.root));
        StaticIntegerBinaryTree testTree6 = new StaticIntegerBinaryTree("1 2 3 7 x x x 4 x x 5 6 x x x");
        System.out.println(isBalanced(testTree6.root));
        StaticIntegerBinaryTree testTree7 = new StaticIntegerBinaryTree("1 2 3 4 x x 4 x x 3 x x 2 x x");
        System.out.println(isBalanced(testTree7.root));
    }
}
