import java.util.Arrays;
import java.util.Iterator;

/**
 * This class creates non-binary tree objects
 * a.k.a. Tree's that can have more than two children
 */
public class StaticIntegerNonBinaryTree
{
    public NoBinaryNode<Integer> root; // Root of the tree

    /**
     * Constructor used to create a StaticIntegerBinaryTree object
     * @param values string of values for the tree  followed by the number of children they contain
     */
    public StaticIntegerNonBinaryTree(String values) {
        this.root = createIntegerNonBinaryTree(Arrays.stream(values.split(" ")).iterator());
    }

    /**
     * Function used to split up string passed into individual values and fill the tree
     * @param iter iterable list of strings containing node value and number of children values
     * @return the root of the tree
     */
    private NoBinaryNode<Integer> createIntegerNonBinaryTree(Iterator<String> iter) {
        int val = Integer.parseInt(iter.next());
        int numOfChildren = Integer.parseInt(iter.next());
        NoBinaryNode<Integer> node = new NoBinaryNode<>(val);
        for (int i = 0; i < numOfChildren; i++) {
            node.children.add(createIntegerNonBinaryTree(iter));
        }
        return node;
    }
}
