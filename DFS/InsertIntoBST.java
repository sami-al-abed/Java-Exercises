/**
 * Given the root node of a valid BST and a value to insert into the tree, return a new root node representing the valid BST with the addition of the new item.
 * If the new item already exists in the binary search tree, do not insert anything.
 *
 * You must expand on the original BST by adding a leaf node. Do not change the structure of the original BST.
 */

/**
 * This class solves the problem by using dfs to go through the binary tree and find where to insert the value.
 * To do this, you first check if the node being observed is null.
 * If the node is null return a new node containing that value
 * If not, you need to find the first null node to insert the value into the binary search tree
 * To do this, you start at the root and compare the value passed to the value of the node.
 * If the value is less than the node's, you set the left pointer equal to the function moved to the left node and run the function again recursively
 * If the value is greater than the node's, you set the right pointer equal to the function moved to the right node and run the function again recursively
 * If the value is equal to the node's, you return the node.
 * When you find a null node, then you have found the spot that the new node needs to be inserted, and you return that node
 */
public class InsertIntoBST
{
    /**
     * This method is used to insert a node into a binary search tree
     * @param root the node being examined
     * @param value the value to be inserted
     * @return the root of the subtree
     */
    public static Node<Integer> insert(Node<Integer> root, int value) {
        if (root == null) {
            root = new Node<>(value);
            return root;
        }
        if (root.value > value) root.left = insert(root.left, value);
        else if (root.value < value) root.right = insert(root.right, value);
        return root;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        StaticIntegerBinaryTree testTree1 = new StaticIntegerBinaryTree("8 4 2 1 x x 3 x x 6 x x 12 10 x x 14 x 15 x x");
        insert(testTree1.root, 7);
        Traversal.preOrderTraversal(testTree1.root);
        System.out.println("\n");

        StaticIntegerBinaryTree testTree2 = new StaticIntegerBinaryTree("37 19 2 x x 28 23 x x 35 x x 44 x 58 52 x x 67 x x");
        insert(testTree2.root, 42);
        Traversal.preOrderTraversal(testTree2.root);
        System.out.println("\n");

        StaticIntegerBinaryTree testTree3 = new StaticIntegerBinaryTree("421 223 79 42 x x 157 133 x x x 327 x 404 356 x x 415 x x 741 626 x x 887 801 795 x x 842 x x 903 x 977 x x");
        insert(testTree3.root, 404);
        Traversal.preOrderTraversal(testTree3.root);
        System.out.println("\n");

        StaticIntegerBinaryTree testTree4 = new StaticIntegerBinaryTree("13 7 5 2 x x x 9 x x 15 14 x x 16 x 18 x x");
        insert(testTree4.root, 12);
        Traversal.preOrderTraversal(testTree4.root);
        System.out.println("\n");

        StaticIntegerBinaryTree testTree5 = new StaticIntegerBinaryTree("x");
        insert(testTree5.root, 18);
        Traversal.preOrderTraversal(testTree5.root);
        System.out.println("\n");

        StaticIntegerBinaryTree testTree6 = new StaticIntegerBinaryTree("37 19 2 x x 28 23 x x 35 x x 44 x 58 52 x x 67 x x");
        insert(testTree6.root, 84);
        Traversal.preOrderTraversal(testTree6.root);
        System.out.println("\n");
    }
}
