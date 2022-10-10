import java.util.ArrayList;
import java.util.List;

/**
 * Class used to create a non-binary tree Node
 * @param <T> the type of value contained within the node
 */
public class NoBinaryNode<T>
{
    public T value; // value of the node
    public List<NoBinaryNode<T>> children; // list containing the children of the node


    /**
     * Constructor for node object when children nodes are not yet known
     * @param value is the value to be contained by the node
     */
    public NoBinaryNode (T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    /**
     * Constructor for node object when children nodes are already known
     * @param value is the value to be contained by the node
     * @param children is the list of the node's children
     */
    public NoBinaryNode (T value, List<NoBinaryNode<T>> children) {
        this.value = value;
        this.children = children;
    }
}
