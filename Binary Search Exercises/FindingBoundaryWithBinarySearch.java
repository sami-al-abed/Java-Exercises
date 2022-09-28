/**
 * An array of boolean values is divided into two sections; the left section consists of all false and the right section consists of all true.
 * Find the boundary of the right section, i.e. the index of the first true element.
 * If there is no true element, return -1.
 */

/**
 * This class is used to solve the problem by looking for true values using binary search until the left and right indices are equal
 * Once they are equal, they break out of the loop and if the left and right indices are true, that index is returned
 */
public class FindingBoundaryWithBinarySearch
{
    /**
     * This function finds the first true value in an array where true values start on the right side of the array
     * @param array is the array to be searched
     * @return the index of the first true value or -1
     */
    public static int findBoundary(boolean[] array) {
        int left = 0, right = array.length - 1;

        while (left < right) {
            int mid = left + (right - left) /2;
            if (!array[mid]) left = mid + 1;
            else right = mid;
        }
        if (array[left]) return left;
        else return -1;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        boolean[] array = {false, false, true, true, true};
        System.out.println(findBoundary(array));
    }
}
