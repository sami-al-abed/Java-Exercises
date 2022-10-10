import java.util.Arrays;
import java.util.Iterator;

/**
 * This class is used to create a static, unchangeable Binary Tree using pre-order traversal of a string
 * This class is used to create trees to test different traversal and search algorithms
 */
public class StaticIntegerBinaryTree
{
    public Node<Integer> root; // root of the binary tree

    /**
     * Constructor used to create a StaticIntegerBinaryTree object
     * @param values string of values for the tree listed in pre-order traversal order
     */
    public StaticIntegerBinaryTree(String values) {
        this.root = createIntegerBinaryTree(Arrays.stream(values.split(" ")).iterator());
    }

    /**
     * Function used to split up string passed into individual values and call the function to fill the tree
     * @param iter list of iterable tree values in pre-order order
     * @return the root of the tree
     */
    private Node<Integer> createIntegerBinaryTree(Iterator<String> iter) {
        String val = iter.next();
        if (val.equals("x")) {
            return null;
        } else {
            Node<Integer> node = new Node<>(Integer.parseInt(val));
            node.left = createIntegerBinaryTree(iter);
            node.right = createIntegerBinaryTree(iter);
            return node;
        }
    }
}
