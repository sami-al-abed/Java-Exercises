/**
 * We have a message consisting of digits 0-9 to decode.
 * Letters are encoded to digits by their positions in the alphabet
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Y -> 25
 * Z -> 26
 *
 * Given a non-empty string of digits, how many ways are there to decode it?
 */

import java.util.Arrays;

/**
 * This problem is solved by using dfs and backtracking to count all possible ways a number as a string can be decoded
 * The function first creates an array of integers used as a memo to keep track of all possible index values to slow the time complexity of the function
 * It then fills the array with a common value
 * dfs is then called on the string and the value of dfs is returned
 *
 * To perform dfs, the function required the String, an index, and the memo as arguments
 * The function first performs the first exit case that checks if you have reached a leaf node by comparing the index to the length of the number being decoded
 * If it is equal, we return 1 because we know we have found a leaf node to be added
 * We then check to see if the digit starts with 0
 * If it does, we return 0 because we know the rest of the string is not a valid value
 * We then check if the current index is listed in the memo
 * If it is, we return that value, since we already know the result
 * An integer is then created to keep track of the number of possible decoded values for the particular node
 * The digit is then checked for the index and index + 1 substrings
 * If either of those integer values are greater than the length of the digit, we skip that value
 * If either of those are found to contain a substring that is less than 27, we enter the child node of that number and search the next section of the digit and add the child values to the integer
 * We then store the integer value in the memo and return the integer value
 */
public class NumberOfWaysToDecodeAMessage
{
    /**
     * This function uses dfs to decode a string in all possible ways and return the number of ways that were found
     * @param digits is a string to be decoded
     * @param index is the current index of the string
     * @param memo is the memo of results for certain indexes used to reduce time complexity
     * @return the number of times the string at the specific node can be decoded
     */
    private static int dfs(String digits, int index, int[] memo) {
        if (index == digits.length()) return 1;
        if (digits.charAt(index) == '0') return 0;
        if (memo[index] != -1) return memo[index];

        int ans = 0;
        for (int i = 1; i < 3; i++) {
            if (index + i <= digits.length() && Integer.parseInt(digits.substring(index, index+i)) < 27) {
                ans += dfs(digits, index + i, memo);
            }
        }
        memo[index] = ans;
        return ans;
    }

    /**
     * This function is used to call dfs to find the number of ways a number can be decoded
     * @param digits number to be decoded
     * @return the number of ways the number can be decoded
     */
    public static int numberOfWays(String digits) {
        int[] memo = new int[digits.length()];
        Arrays.fill(memo, -1);
        return dfs(digits, 0, memo);
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        System.out.println(numberOfWays("12"));
        System.out.println("-----------------------------------------------------");

        System.out.println(numberOfWays("123"));
        System.out.println("-----------------------------------------------------");

        System.out.println(numberOfWays("11223"));
        System.out.println("-----------------------------------------------------");

        System.out.println(numberOfWays("313"));
        System.out.println("-----------------------------------------------------");

        System.out.println(numberOfWays("02"));
        System.out.println("-----------------------------------------------------");
    }
}
