/**
 * Given an array of integers sorted in increasing order and a target, find the index of the first element in the array that is larger than or equal to the target.
 * Assume that it is guaranteed to find a satisfying number.
 */

/**
 * This class is used to solve the problem by looking for larger or equal values using binary search
 * A variable first is used to find the index of the closest larger than value found by the calculated mid value
 * If the mid value is larger than target, that index is saved and the left of the list is searched for values closer to the target
 * If the mid value is equal to the target, then there are no other closer values and mis is returned
 * first will contain the index of the closest larger than value to the target and that will be returned
 */
public class FirstNotSmaller
{
    /**
     *
     * @param array is the array of numbers to be searched
     * @param target value to either be found or closest larger number to be found
     * @return the index of either the target or the closest number > the targer
     */
    public static int firstNotSmaller(int[] array, int target) {
        int left = 0, right = array.length - 1, first = 0;

        while (left <= right) {
            int mid = left + (right - left) /2;
            if (array[mid] < target) left = mid + 1;
            else if (array[mid] > target) {
                first = mid;
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return first;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 7, 11, 13, 17, 19};
        System.out.println(firstNotSmaller(array, 6));
    }
}
