/**
 * Given an integer, find its square root without using the built-in square root function.
 * Only return the integer part (truncate the decimals).
 */

/**
 * This class is used to find the truncated square root value using binary search
 * The left and right bounds go from 0 to n (the number who's square root is to be found)
 * n is the right bound rather than n - 1 for the edge case of numbers 1 & 0 who's square root is themselves
 * This takes the middle of the two bound values (left and right) and checks if that value * itself is greater than, less than,or equal to n
 * If this value is equal to n, the mid value is returned
 * If the value of the square root is not an integer, you will need to find the closest truncated integer value
 * This is done by checking if the value * itself is the largest integer less than the square root of n
 * If it is less than, then you save that value and check the right of it to be sure that it is the largest less than value * itself
 * When left > right, you return the stored square root value if the absolute square root does not exist
 */
public class SquareRoot
{
    /**
     * Function used to find the truncated square root of a number using binary search
     * @param n is the number whose square root is to be found
     * @return the truncated square root of n
     */
    public static int squareRoot(int n) {
        int left = 0, right = n, sqrt = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(mid * mid == n) return mid;
            else if (mid * mid > n) right = mid - 1;
            else {
                sqrt = mid;
                left = mid + 1;
            }
        }
        return sqrt;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        System.out.println(squareRoot(10));
        System.out.println(squareRoot(144));
        System.out.println(squareRoot(121));
        System.out.println(squareRoot(6));
        System.out.println(squareRoot(22));
        System.out.println(squareRoot(19));
        System.out.println(squareRoot(9));
    }
}
