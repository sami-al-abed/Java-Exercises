/**
 * Given a ternary tree (each node of the tree has at most three children), find all root-to-leaf paths.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This class solves the problem by using dfs to add elements of a tree to a list containing nodes in a current path and then turning that into a path
 * This is done by first creating a list to hold all possible paths
 * If the root is not null, dfs is called and the root, the current path (empty at first), and the list to contain all paths is passed
 * The node is first checked to see how many children it contains.
 * If the node has children, the children are parsed through in a loop
 * In this loop, the current node's value is added to the path, and then it's recursively repeated on a child node
 * until a node with no children is reached
 * When a node with no children is reached, that node adds its value to the path and all the values in the path are joined with -> to create a path
 * That node is then removed from the path and the call stack returns to the parent node.
 * When it goes back to the parent node's function, the parent node is removed from the stack and then its next child is analyzed
 * It is important to remove the parent node from the path and re-add it when looking at the next child to avoid repeats
 * This is repeated until all paths are found and the function has gone through all the root's children
 */
public class TernaryTreePaths
{
    /**
     * This function is used to find all paths recursively and add them to the list of paths
     * @param root the node being looked at
     * @param path the nodes in the current path in order
     * @param result all paths in the tree
     */
    public static void dfs(NoBinaryNode<Integer> root, List<String> path, List<String> result) {
        if (root.children.isEmpty()) {
            path.add(Integer.toString(root.value));
            result.add(String.join("->", path));
            path.remove(path.size() - 1);
            return;
        }
        for (NoBinaryNode<Integer> child : root.children) {
            path.add(Integer.toString(root.value));
            dfs(child, path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * This function is used to call the function that finds all paths and then returns the results
     * @param root the root of the ternary tree being observed
     * @return a list of all paths in the tree
     */
    public static List<String> findTreePaths(NoBinaryNode<Integer> root) {
        List<String> paths = new ArrayList<>();
        if (root != null) dfs(root, new ArrayList<>(), paths);
        return paths;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        StaticIntegerNonBinaryTree tree1 = new StaticIntegerNonBinaryTree("1 3 2 1 5 0 3 0 4 0");
        for (String path : findTreePaths(tree1.root)) System.out.println(path);
        System.out.println("\n");

        StaticIntegerNonBinaryTree tree2 = new StaticIntegerNonBinaryTree("1 3 2 3 3 0 4 0 7 0 5 0 6 0");
        for (String path : findTreePaths(tree2.root)) System.out.println(path);
        System.out.println("\n");

        StaticIntegerNonBinaryTree tree3 = new StaticIntegerNonBinaryTree("1 3 2 1 3 0 4 0 6 0");
        for (String path : findTreePaths(tree3.root)) System.out.println(path);
        System.out.println("\n");
    }

}
