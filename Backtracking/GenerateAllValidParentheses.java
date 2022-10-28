/**
 * Given an integer n, generate all strings with n matching parentheses.
 *
 * "matching" parentheses mean:
 * - there is equal number of opening and closing parentheses.
 * - each opening parenthesis has matching closing parentheses.
 *
 * For example, () is a valid string but )( is not a valid string because ) has no matching parenthesis before it and ( has no matching parenthesis after it.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This class solves the problem by using dfs and backtracking to make all possible combinations of parentheses
 * We first create a list to contain the string of parentheses combinations and pass that to the dfs function
 * The dfs function will need to contain additional states to react to different situations and prune the tree
 * The additional states to be kept track of here are the number of left and right brackets are in the current string of parentheses, so this is an argument in the function
 * A StringBuilder is used to build the string and the number of parentheses is also passed to the dfs function
 * The function first checks if the length of the string builder is equal to n*2 (since n = number of parentheses = 4 characters) and adds the string to the list and returns if true
 * Next for both ( and ) all possibilities are gone through unless found to be invalid at any point
 * We know that the two pruning conditions that would need to be skipped are when we are about to add ( to the string when there are already n number of ( in the string and
 * when ) is going to be added to the string when there are already an even number of ( and ) (we know that the bracket wont be closed in this case making it invalid)
 * If either of these conditions are encountered, the loop continues to the next character or ends the function
 * The current bracket character is then added to the StringBuilder
 * The additional states are then incremented depending on which character is being observed
 * the dfs function is then recursively called to enter the child branches of the dfs tree (if not entering a leaf branch)
 * Once all possibilities for that node are created, the additional states are reverted and the current observed character is removed from the StringBuilder
 * When the loop has completed at the root node, the function has filled all possible parentheses string into the list and that list is returned in the calling function
 */
public class GenerateAllValidParentheses
{
    /**
     * This function uses dfs to populate a list of strings with all possible combinations of n number of parentheses
     * @param parentheses list to be populated with parentheses
     * @param sb StringBuilder object used to form strings
     * @param lCount count of left brackets in the string
     * @param rCount count of right brackets in the string
     * @param n number of valid parentheses needed per combination
     */
    private static void dfs(List<String> parentheses, StringBuilder sb, int lCount, int rCount, int n) {
        if (sb.length() == n * 2) {
            parentheses.add(sb.toString());
            return;
        }
        for (char par : new char[]{'(', ')'}) {
            if (par == '(' && lCount >= n) continue;
            if (par == ')' && rCount >= lCount) continue;

            sb.append(par);

            if (par == '(') lCount++;
            else rCount++;

            dfs(parentheses, sb, lCount, rCount, n);

            sb.deleteCharAt(sb.length() - 1);

            if (par == '(') lCount--;
            else rCount--;
        }
    }

    /**
     * This function is used to generate a specified number of all possible matching parentheses combinations using dfs
     * @param n is the number of matching parentheses in each string
     * @return a list of all matching parentheses possibilities
     */
    public static List<String> generateParentheses(int n) {
        List<String> parentheses = new ArrayList<>();
        dfs(parentheses, new StringBuilder(), 0, 0, n);
        return parentheses;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        for (String parentheses : generateParentheses(2)) System.out.println(parentheses);
        System.out.println("-----------------------------------------------------");

        for (String parentheses : generateParentheses(3)) System.out.println(parentheses);
        System.out.println("-----------------------------------------------------");

        for (String parentheses : generateParentheses(4)) System.out.println(parentheses);
        System.out.println("-----------------------------------------------------");

        for (String parentheses : generateParentheses(5)) System.out.println(parentheses);
        System.out.println("-----------------------------------------------------");
    }
}
