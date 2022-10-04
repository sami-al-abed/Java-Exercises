/**
 * Class used to create a binary tree Node
 */
public class Node<T>
{
    public T value; // value stored in node
    public Node<T> left; // node's left child
    public Node<T> right; // node's right child

    /**
     * Constructor for node object when left and right nodes are not yet known
     * @param value is the value to be contained by the node
     */
    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Constructor for node object when left and right nodes are known
     * @param value is the value to be contained by the node
     * @param left is the left child of the node
     * @param right is the right child of the node
     */
    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
