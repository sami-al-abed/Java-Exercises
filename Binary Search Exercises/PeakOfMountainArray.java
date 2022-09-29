/**
 * A mountain array is defined as an array that
 *
 * 1) Has at least 3 elements
 * 2) Has an element with the largest value called "peak", with index k.
 *    The array elements monotonically increase from the first element to A[k], and then monotonically decreases from A[k + 1] to the last element of the array.
 *    Thus creating a "mountain" of numbers.
 * 3) That is, given A[0]<...<A[k-1]<A[k]>A[k+1]>...>A[n-1], we need to find the index k.
 *    Note that the peak element is neither the first nor the last element of the array.
 *
 * Find the index of the peak element. Assume there is only one peak element.
 */

/**
 * This class solves the problem by using binary search separating the list to find the first index of the numbers that continuously decrease
 * The peak and all numbers after it are greater than the number that comes after it
 * Because of this, binary search needs to find the range of those numbers and return its first element's index
 * When the mid value is checked, the number that comes after the mid value is also checked
 * If the number after the mid value is greater than the mid value, then we know for sure that the mid value is not the peak and the left value is moved to mid + 1
 * If the number after the mid value is less than the mid value, then we know it is inside the range we are looking for and could be the peak, so we save its index and move
 * the right value to mid - 1
 * We know that once we find a value in that range, everything to the left of that value will either be greater than the saved or will not be in the range,
 * so it is necessary to continue looking to the left
 */
public class PeakOfMountainArray
{
    /**
     * Function used to find the peak of the mountain array
     * @param array mountain array to be searched
     * @return index of mountain array peak
     */
    public static int findPeak(int[] array) {
        int left = 0, right = array.length - 1, index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[mid + 1]) left = mid + 1;
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
        int[] array = {0, 1, 2, 12, 22, 32, 42, 52, 62, 72, 82, 92, 102, 112, 122, 132, 133, 132, 111, 100, 93, 82, 55, 41, 26, 13, 9, 8, 0};
        System.out.println(findPeak(array));
    }
}
