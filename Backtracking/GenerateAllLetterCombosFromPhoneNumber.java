/**
 * Given a phone number that contains digits 2-9, find all possible letter combinations the phone number could translate to.
 * 2 - A B C
 * 3 - D E F
 * 4 - G H I
 * 5 - J K L
 * 6 - M N O
 * 7 - P Q R S
 * 8 - T U V
 * 9 - W X Y Z
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class solves the problem by performing dfs and backtracking on all possible combinations of characters
 * I first created a map containing all the digits as keys and their associated characters as the values
 * I then created a function that takes a string containing the digits as its argument
 * This function then creates a list of strings to contain all character combinations from the digits
 * The function then calls dfs passing the String of digits as a char array, the starting index, a string builder, and the list of strings
 * The dfs function goes through each number in the digits by using each recursive call to analyze each digit's characters
 * It first adds the character to the stringbuilder, then recursively calls dfs to look at the next letter and get all combinations
 * This is repeated until the index = the number of digits, and that current combo is added to the list
 * The last character is then removed and the next character is added and the process is repeated until we are back at the first letter and the next character combos are analyzed
 * When dfs is complete, the list is returned
 */
public class GenerateAllLetterCombosFromPhoneNumber
{
    static Map<Character, char[]> digitMap = Map.of(
            '2', "abc".toCharArray(),
            '3', "def".toCharArray(),
            '4', "ghi".toCharArray(),
            '5', "jkl".toCharArray(),
            '6', "mno".toCharArray(),
            '7', "pqrs".toCharArray(),
            '8', "tuv".toCharArray(),
            '9', "wxyz".toCharArray()
    ); // This is a map containing the digits as characters and an array of their character values

    /**
     * This function uses dfs to search through all possible character combinations created by some digits and fill a list with those combos
     * @param digits the numbers to be looked at
     * @param index the current index being analyzed in the array
     * @param currentString the currentString being built from the characters
     * @param combos list of all possible character combinations by digits
     */
    public static void dfs(char[] digits, int index, StringBuilder currentString, List<String> combos) {
        if (index == digits.length) {
            combos.add(currentString.toString());
            return;
        }
        for (char letter : digitMap.get(digits[index])) {
            currentString.append(letter);
            dfs(digits, index + 1, currentString, combos);
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }

    /**
     * This function fills a list with all combos of characters that can be created by the digits in a provided string by calling dfs
     * @param digits the numbers to be looked at
     * @return The list of all character combinations created by the numbers
     */
    public static List<String> letterCombinationsOfPhoneNumber(String digits) {
        List<String> combos = new ArrayList<>();
        dfs(digits.toCharArray(), 0, new StringBuilder(), combos);
        return combos;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        for (String combo : letterCombinationsOfPhoneNumber("56")) System.out.println(combo);
        System.out.println("\n");

        for (String combo : letterCombinationsOfPhoneNumber("23")) System.out.println(combo);
        System.out.println("\n");

        for (String combo : letterCombinationsOfPhoneNumber("235")) System.out.println(combo);
        System.out.println("\n");

        for (String combo : letterCombinationsOfPhoneNumber("")) System.out.println(combo);
        System.out.println("\n");
    }
}
