/**
 * Find all n-letter words composed by 'a' and 'b', return them in a list of strings in lexicographical order.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to solve the problem by using dfs and backtracking
 * It first creates a list to hold all possible combinations and then passes that list to the dfs function to be filled
 * The dfs function then creates a "tree" and searches for leaf nodes to add to the solution
 * To do this, the function takes 'a', adds it to the current combo, and then recursively calls the function until the current combo is the length of n
 * It then returns and goes back to the previous length (n - 1), removes 'a' from the combo, and then repeats the previous step with b
 * This is repeated until the combos have backtracked to the first iteration and the loop completes
 */
public class FindAllABCombos
{
    /**
     * This function searches all possibilities of a/b letter combinations and adds them to a list
     * @param n is the length of the combinations
     * @param currentCombo is a list of letters in a current combination
     * @param combos is the list of all possible combinations that is added to
     */
    public static void dfs(int n, List<String> currentCombo, List<String> combos) {
        if (currentCombo.size() == n) {
            combos.add(String.join("", currentCombo));
            return;
        }
        for (String letter : new String[] {"a", "b"}) {
            currentCombo.add(letter);
            dfs(n, currentCombo, combos);
            currentCombo.remove(currentCombo.size() - 1);
        }
    }

    /**
     * This function is used to call the function to find all possible combinations with a specified length
     * @param n is the length of the possible combinations
     * @return the list of all possible combinations
     */
    public static List<String> letterCombinations(int n) {
        List<String> combos = new ArrayList<>();
        dfs(n, new ArrayList<>(), combos);
        return combos;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        for (String combo : letterCombinations(1)) System.out.println(combo);
        System.out.println("\n");

        for (String combo : letterCombinations(2)) System.out.println(combo);
        System.out.println("\n");

        for (String combo : letterCombinations(3)) System.out.println(combo);
        System.out.println("\n");

        for (String combo : letterCombinations(0)) System.out.println(combo);
        System.out.println("\n");
    }
}
