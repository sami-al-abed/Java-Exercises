/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This problem is solved by using dfs and backtracking to break up the string into palindrome substrings
 *
 * I first created a function that returns true or false on if a string is a palindrome or not
 * This is done by comparing the start and end values, and if the same moving the two pointers further towards the center of the string
 * If the two characters being observed are not the same, then we know it is not a palindrome and false is returned
 * If all compared characters are found to be the same, then true is returned
 *
 * The function used to solve this was then created.
 * This function creates a 2-D list to store lists of palindrome substrings in
 * The function then calls dfs to populate the list of lists of strings and returns that list
 *
 * The dfs function is the final piece of the puzzle to solving this question.
 * This function breaks down the string into substrings of increasing size from 1 character to the length of the string
 * If the substring is a palindrome, that substring is added to a temporary list and then dfs is called again
 * on the string with the starting point of the string being the end point of the previous string.
 * If the starting point is found to be the same value as the string length, then the temporary list is added to the list and the function returns
 * After all possibilities are found for a known palindrome, that palindrome is removed from the list and the next substring with one extra
 * character is observed.
 */
public class PartitioningAStringIntoPalindromes
{
    /**
     * This function is used to confirm if a string is a palindrome or not
     * @param s string to be observed
     * @return whether the string is a palindrome or not
     */
    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * This function is used to perform dfs of a string to break it up into all possible combinations of palindrome substrings and
     * put those into a list
     * @param s the string to be broken up
     * @param start the starting index for the current substring
     * @param currentList the current list of palindrome substrings
     * @param palindromeLists the full list of palindrome substring lists
     */
    private static void dfs(String s, int start, List<String> currentList, List<List<String>> palindromeLists) {
        if (start == s.length()) {
            List<String> tempList = new ArrayList<>(currentList);
            palindromeLists.add(tempList);
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (!isPalindrome(s.substring(start, end+1))) continue;
            currentList.add(s.substring(start, end+1));
            dfs(s, end+1, currentList, palindromeLists);
            currentList.remove(currentList.size() - 1);
        }
    }

    /**
     * Function used to partition a string into multiple lists of palindromes
     * @param s The string to be divided
     * @return the list of palindrome substring lists
     */
    public static List<List<String>> partitionIntoPalindromes(String s) {
        List<List<String>> palindromeLists = new ArrayList<>();
        if (s.length() > 0) dfs(s, 0, new ArrayList<>(), palindromeLists);
        return palindromeLists;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        for (List<String> list : partitionIntoPalindromes("aab")) {
            for (String palindrome : list) System.out.println(palindrome + ", ");
            System.out.println("\n");
        }
        System.out.println("-----------------------------------------------------");

        for (List<String> list : partitionIntoPalindromes("aba")) {
            for (String palindrome : list) System.out.println(palindrome + ", ");
            System.out.println("\n");
        }
        System.out.println("-----------------------------------------------------");

        for (List<String> list : partitionIntoPalindromes("aabaa")) {
            for (String palindrome : list) System.out.println(palindrome + ", ");
            System.out.println("\n");
        }
        System.out.println("-----------------------------------------------------");

        for (List<String> list : partitionIntoPalindromes("abcdefg")) {
            for (String palindrome : list) System.out.println(palindrome + ", ");
            System.out.println("\n");
        }
        System.out.println("-----------------------------------------------------");

        for (List<String> list : partitionIntoPalindromes("")) {
            for (String palindrome : list) System.out.println(palindrome + ", ");
            System.out.println("\n");
        }
        System.out.println("-----------------------------------------------------");

        for (List<String> list : partitionIntoPalindromes(" ")) {
            for (String palindrome : list) System.out.println(palindrome + ", ");
            System.out.println("\n");
        }
        System.out.println("-----------------------------------------------------");
    }
}
