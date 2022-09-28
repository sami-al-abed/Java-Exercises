/**
 * Given a sorted array of integers and a target integer, find the first occurrence of the target and return its index.
 * Return -1 if the target is not in the array.
 */

/**
 * This class is used to solve the problem by using binary search
 * This solution first uses binary search to find AN occurrence of the target value
 * Once the target value is found, the index of the find is stored and the search continues on the left of the list to check if there was a sooner occurrence
 * When the left index used for binary search is larger than the right, then all possibilities have been searched
 * If the target was not found, -1 is returned
 */
public class FirstOccurrenceInSortedArray
{
    /**
     * This function is used to solve the problem using binary search
     * @param array is the array of numbers to be searched
     * @param target value of number to find first occurrence of
     * @return the index of the
     */
    public static int findFirstOccurrence(int[] array, int target) {
        int first = -1, left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) left = mid + 1;
            else if (array[mid] > target) right = mid - 1;
            else {
                first = mid;
                right = mid - 1;
            }
        }
        return first;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        int[] array = {1, 3, 3, 3, 3, 6, 10, 10, 10, 100};
        System.out.println(findFirstOccurrence(array, 3));
    }
}
