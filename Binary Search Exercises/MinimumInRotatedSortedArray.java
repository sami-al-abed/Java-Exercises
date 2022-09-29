/**
 * A sorted array of unique integers was rotated at an unknown pivot.
 * For example, [10, 20, 30, 40, 50] becomes [30, 40, 50, 10, 20].
 * Find the index of the minimum element in this array.
 * All the numbers are unique.
 */

/**
 * This class is used to solve the problem by using binary search to find the first index of the range of right values that are less than the left values
 * It first takes the end value as a comparator to treat this problem as if it is an array of true/ false values
 * All numbers on the right that are less than numbers on the left are true while the rest of the left numbers are false
 * while the left index <= the right index, a while loop runs
 * the mid value is calculated and if this mid value points to a number greater than the end value the left index is moved 1 to the right of the mid index
 * When a mid points to a number less than the end value, the stored index is now equal to mid and the right index is moved 1 to the left of the mid index
 * the end value is always compared to the mid value, because once the first number less than the end value is found, all numbers to the left
 * of that value are either greater than the end value or less than the current minimum value, which you are looking for
 */
public class MinimumInRotatedSortedArray
{
    /**
     * Function used to find the minimum number in a sorted array that has been rotated
     * @param array array to be searched
     * @return index of the smallest value
     */
    public static int findMin(int[] array) {
        int left = 0, right = array.length - 1, index = -1;
        int endVal = array[right];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > endVal) left = mid + 1;
            else {
                index = mid;
                right = mid - 1;
            }
        }
        return index;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        int[] array = {60, 70, 80, 90, 100, 110, 120, 125, 10, 20, 30, 40, 50};
        System.out.println(findMin(array));
    }
}
