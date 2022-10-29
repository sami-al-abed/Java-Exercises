/**
 * Given a string of unique letters, find all of its distinct permutations.
 *
 * Permutation means arranging things with an order. For example, permutations of [1, 2] are [1, 2] and [2, 1]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This problem is solved by using dfs and backtracking to find all possible permutations of the string
 * We first create a list of strings used to contain all possible permutations
 * We then create an array of integers the size of string.length() filled with -1 to keep track of which characters have been checked
 * After this dfs is used to fill the list of strings
 *
 * For dfs, the string in the StringBuilder is added to the list when the StringBuilder is the same length as the string. This is how we know we have reached a leaf and need to exit
 * Each character is then observed in the string.
 * If the character is found to already exist in the string, the loop moves on to the next character
 * the character is then appended to the StringBuilder and that character is noted in the memo array
 * the string and memo are then sent to dfs recursively to visit the child nodes of the current node being observed.
 * Once all possibilities of child leaf nodes are found and the current node is visited again,
 * the character is removed from the memo and the StringBuilder and the next character is observed until the entire tree is searched and
 * the function completes
 */
public class GenerateAllPermutations
{
    /**
     * This function uses dfs to find all possible permutations of a string and add populate a list with those permutations
     * @param s the string we are analyzing to find all possible permutations
     * @param permutations is the list we are filling with all possible permutations of s
     * @param sb is a StringBuilder we use to build out permutation
     * @param memo is a memo used to keep track of what characters from s have been used in the current permutation
     */
    private static void dfs(String s, List<String> permutations, StringBuilder sb, int[] memo) {
        if (sb.length() == s.length()) {
            permutations.add(sb.toString());
            return;
        }
        for(int i = 0; i < s.length(); i++) {
            if (memo[i] != -1) continue;

            sb.append(s.charAt(i));
            memo[i] = 0;
            dfs(s, permutations, sb, memo);
            memo[i] = -1;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * This function is used to generate all possible permutations of a string using dfs
     * @param s the string we are analyzing to find all possible permutations
     * @return a list of strings containing all possible permutations
     */
    public static List<String> generatePermutations(String s) {
        List<String> permutations = new ArrayList<>();
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        dfs(s, permutations, new StringBuilder(), memo);
        return permutations;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        for (String permutations : generatePermutations("a")) System.out.println(permutations);
        System.out.println("-----------------------------------------------------");

        for (String permutations : generatePermutations("aba")) System.out.println(permutations);
        System.out.println("-----------------------------------------------------");

        for (String permutations : generatePermutations("bcda")) System.out.println(permutations);
        System.out.println("-----------------------------------------------------");

        for (String permutations : generatePermutations("dbba")) System.out.println(permutations);
        System.out.println("-----------------------------------------------------");
    }
}
