/**
 * Given a string and a list of words, determine if the string can be constructed from concatenating words from the list of words.
 * A word can be used multiple times.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This problem is solved by using dfs and backtracking to check if a string can be concatenated by a list of strings
 * To do this we call a boolean dfs function containing the string, the list of words, an index, and a boolean memo as arguments
 * This function first checks if the index is equal to the length of the string
 * This is how we know we have reached a leaf and the condition is true
 * If not, we check if the current index has already been visited in the memo. If it has, we return the memo at that index to save time
 * If not, we create a boolean variable and initially set it to false to store the return value
 * We then loop through each value in the list of strings.
 * If the substring starting at the index is found to start with a word in the list, the boolean value is compared to a dfs call of the index + the length of the current word
 * This continues until a leaf is found and the memo contains all the needed values to return to the root node.
 * After the loop is completed, the value of the boolean is recorded in the memo and the function returns until reaching the root
 */
public class WordBreak
{
    /**
     * This function implements dfs to search a string to see if a string can be concatenated by a list of words
     * @param s String to be observed
     * @param words list of strings to compare to s
     * @param index the current index of the string
     * @param memo a memo of all values to reduce time complexity
     * @return true or false on if you can create all words from a word
     */
    private static boolean dfs(String s, List<String> words, int index, Boolean[] memo) {
        if (index == s.length()) return true;
        if (memo[index] != null) return memo[index];

        boolean ans = false;
        for(String word : words) {
            if (s.substring(index).startsWith(word)) {
                ans = ans || dfs(s, words, index + word.length(), memo);
            }
        }
        memo[index] = ans;
        return ans;
    }

    /**
     * This function is used to call dfs to tell whether  a string can be concatenated by a list of words or not
     * @param s String to be observed
     * @param words list of strings to compare to s
     * @return true or false on if you can create all words from a word
     */
    public static boolean wordBreak(String s, List<String> words) {
        return dfs(s, words, 0, new Boolean[s.length()]);
    }


    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        System.out.println(wordBreak("aab", new ArrayList<>(List.of("a", "c"))));
        System.out.println("-----------------------------------------------------");

        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                                    new ArrayList<>(List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"))));
        System.out.println("-----------------------------------------------------");

        System.out.println(wordBreak("abcd", new ArrayList<>(List.of("a", "abc", "b", "cd"))));
        System.out.println("-----------------------------------------------------");
    }
}
