/**
 * This class is used to create a static, unchangeable Binary Tree using pre-order traversal of a string
 * This class is used to create trees to test different traversal and search algorithms
 */
public class StaticIntegerBinaryTree
{
    public Node<Integer> root; // root of the binary tree
    private int index; // index used to parse through the array of strings created by the string passed to the constructor

    /**
     * Constructor used to create a StaticIntegerBinaryTree object
     * @param values string of values for the tree listed in pre-order traversal order
     */
    public StaticIntegerBinaryTree(String values) {
        this.index = 0;
        this.root = createIntegerBinaryTree(values);
    }

    /**
     * Function used to split up string passed into individual values and call the function to fill the tree
     * @param values string of values for the tree listed in pre-order traversal order
     * @return the root of the tree
     */
    private Node<Integer> createIntegerBinaryTree(String values) {
        String[] treeValues = values.split(" "); // Array of strings that contain the values for the tree listed in pre-order traversal order
        return parseStringAndCreateTree(treeValues, root);
    }

    /**
     * This function is used to fill the tree using pre-order traversal
     * @param values array of strings that contain the values for the tree listed in pre-order traversal order
     * @param node the current node being examined
     * @return the current node
     */
    private Node<Integer> parseStringAndCreateTree(String[] values, Node<Integer> node) {
        // if values is empty or value = x return null
        if (values.length == 0 || values[index].equals("x")) {
            index++;
            return null;
        } else {
            node = new Node<>(Integer.parseInt(values[index++]));
            node.left = parseStringAndCreateTree(values, node);
            node.right = parseStringAndCreateTree(values, node);
            return node;
        }
    }
}
