/**
 * Max depth of a binary tree is the longest root-to-leaf path. Given a binary tree, find its max depth.
 */

/**
 * This class solves the problem by using dfs to first find a leaf node and then backtrack adding 1 to each step until back at the root
 * This is done on the right side then the left side, then the values are compared.
 * The max value is returned.
 * If the root is null, the function returns 0, if not it gets the number of nodes on the branch with the longest height and subtracts that by 1 to get the height of the tree
 */
public class MaxDepthOfBinaryTree
{
    /**
     * This function is used to perform dfs on a binary tree to count the depth of the nodes and
     * return the number of nodes on the branch with the max depth
     * @param root the node being examined
     * @return the number of nodes on the branch counting from the bottom of the tree
     */
    public static int dfs(Node<Integer> root) {
        if (root == null) return 0;
        return  Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

    /**
     * This function is used to get the max height of a binary tree
     * @param root is the root of the binary tree
     * @return the max height of the tree
     */
    public static int maxDepth(Node<Integer> root) {
        return (root != null) ? dfs(root) - 1 : 0;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        StaticIntegerBinaryTree testTree1 = new StaticIntegerBinaryTree("5 4 3 x x 8 x x 6 x x");
        System.out.println(maxDepth(testTree1.root));
        StaticIntegerBinaryTree testTree2 = new StaticIntegerBinaryTree("1 x x");
        System.out.println(maxDepth(testTree2.root));
        StaticIntegerBinaryTree testTree3 = new StaticIntegerBinaryTree("x");
        System.out.println(maxDepth(testTree3.root));
        StaticIntegerBinaryTree testTree4 = new StaticIntegerBinaryTree("6 x 9 x 11 x 7 x x");
        System.out.println(maxDepth(testTree4.root));
    }
}
