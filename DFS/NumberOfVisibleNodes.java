/**
 * In a binary tree, we define a node "visible" when no node on the root-to-itself path (inclusive) has a greater value.
 * The root is always "visible" since there are no other nodes between the root and itself.
 * Given a binary tree, count the number of "visible" nodes.
 */

/**
 * This class solves the problem using dfs to search for nodes that have values greater than their predecessors
 * The numberOfVisibleNodes function is called and the root of a binary tree is passed to it
 * This function then takes the root and passes that to the dfs function to find the number of visible nodes
 * The current max value and the node being examined are passed as arguments to the dfs function. (The root of the tree and Integer.MIN_VALUE are passed when function is called)
 * The function first checks if the value of the current node is greater that or equal to the previous nodes.
 * If the current node value is greater than the previous ones in its lineage, 1 is added to the total
 * The dfs function is then called recursively to find the number of visible nodes on the left subtree, and this value is added to the total
 * It is then repeated on the right subtree
 * This recursion occurs until we backtrack back to the root and the function then returns the total at the root to the calling function
 */
public class NumberOfVisibleNodes
{
    /**
     * This function uses dfs to find all the visible nodes in the binary tree
     * @param root the node being examined in the tree
     * @param maxValue the current maxValue for the predecessors of the current node
     * @return the total number of visible nodes in the current tree/subtree
     */
    public static int dfs(Node<Integer> root, int maxValue) {
        if (root == null) return 0;

        int total = 0;
        if (root.value >= maxValue) {
            total++;
            maxValue = root.value;
        }

        total += dfs(root.left, maxValue);
        total += dfs(root.right, maxValue);
        return total;
    }

    /**
     * This function is used to call the dfs function used to get the number of visible nodes in the binary tree
     * @param root is the root node of the binary tree
     * @return the total number of visible nodes found by the dfs function
     */
    public static int numberOfVisibleNodes(Node<Integer> root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        StaticIntegerBinaryTree testTree1 = new StaticIntegerBinaryTree("5 4 3 x x 8 x x 6 x x");
        System.out.println(numberOfVisibleNodes(testTree1.root));
        StaticIntegerBinaryTree testTree2 = new StaticIntegerBinaryTree("-100 x -500 x -50 x x");
        System.out.println(numberOfVisibleNodes(testTree2.root));
        StaticIntegerBinaryTree testTree3 = new StaticIntegerBinaryTree("9 8 11 x x 20 x x 6 x x");
        System.out.println(numberOfVisibleNodes(testTree3.root));
        StaticIntegerBinaryTree testTree4 = new StaticIntegerBinaryTree("5 8 3 x x 8 x x 6 x x");
        System.out.println(numberOfVisibleNodes(testTree4.root));
    }
}
