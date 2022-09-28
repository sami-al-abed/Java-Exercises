/**
 * An array of boolean values is divided into two sections; the left section consists of all false and the right section consists of all true.
 * Find the boundary of the right section, i.e. the index of the first true element.
 * If there is no true element, return -1.
 */

/**
 * This class is used to solve the problem by looking for true values using binary search
 * A variable trueBound is used to find true value indexes found by the calculated mid value
 * If the mid value is true, that index is saved and the left of the list is searched for more true values
 * If there are no more true values to be found, the left bound was found and trueBound is returned
 */
public class FindingBoundaryWithBinarySearchAlternate
{
    /**
     * This function finds the first true value in an array where true values start on the right side of the array
     * @param array is the array to be searched
     * @return the index of the first true value or -1
     */
    public static int findBoundary(boolean[] array) {
        int left = 0, right = array.length - 1, trueBound = -1;

        while (left <= right) {
            int mid = left + (right - left) /2;
            if (!array[mid]) left = mid + 1;
            else {
                trueBound = mid;
                right = mid - 1;
            }
        }
        return trueBound;
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
