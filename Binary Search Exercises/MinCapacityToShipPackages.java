/**
 * There are n packages that need to be transported from one city to another, and you need to deliver the packages within d days.
 * You are given an array weight, where for the ith package, the weight of the package is weights[i].
 * You are required to deliver the packages with a rental truck in the same order as it appears in the list.
 * The rental trucks come in different sizes. The bigger trucks have greater weight capacity but cost more to rent.
 * To minimize cost, you want to deliver the packages in one truck once per day, with a weight capacity as small as possible to save on rental cost.
 * What is the minimum weight capacity of the truck that is required to deliver all packages within d days?
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class solves the problem by using binary search
 *
 * Given a list of weights that we have to ship in order, we can create an initial range of feasible daily weights.
 * We know that the minimum possible daily weight has to be equal to the weight of the heaviest value, so the initial minimum in the range
 * is equal to the largest value in the provided list.
 * We know that the most the truck can possibly carry is all the weights at once, so the initial maximum is equal to the sum of all weights.
 * We know that the minimum max daily value should be somewhere between these two numbers, therefore we use binary search to find the solution.
 * In each search, we take the middle of max and min values and check the feasibility.
 * If it is not feasible, we move the minimum value to mid + 1 since we know everything <= mid is not going to work.
 * If it is feasible, we save that value and move the max range to mid value - 1 to see if there are smaller values that work as well.
 * We then return the last found feasible value.
 *
 * To check feasibility we have to go through each weight and see if it is possible to load the truck with the middle value of weight per day,
 * but not go over the limited number of days we have.
 * To do this, we have a variable equal to the daily weight allowance and a variable that will count how many days it will take to ship at the given weight.
 * We go through each weight in the array
 * If the weight is less than or equal to the current daily allowance, we subtract that weight from the daily allowance and look at the next weight
 * If the weight is greater than the current daily allowance, we increment the number of days used by 1 and reset the daily allowance to the given number
 * If the number of days used is greater than the number of days allowed, we return false
 * If the number of days used is less than or equal to the number of days allowed, we know it is possible to use this weight and return true
 */
public class MinCapacityToShipPackages
{
    /**
     * Function that takes a list of weights, a daily weight value, and number of days needed to ship
     * and returns true or false on whether it is feasible to ship that weight in the given number of days or not
     * @param weights list of weights to be shipped in order
     * @param val value of the weight we want to examine
     * @param d number of days allowed to ship the weights
     * @return true or false of whether we can ship the desired weight in the target number of days or not
     */
    public static boolean isFeasible(List<Integer> weights, int val, int d) {
        int days = 1;
        int remainingWeight = val;
        int i = 0;

        while (i < weights.size()) {
            if (remainingWeight >= weights.get(i)) {
                remainingWeight -= weights.get(i);
                i++;
            } else {
                remainingWeight = val;
                days++;
            }
        }

        return d >= days;
    }

    /**
     * Function used to find the minimum max daily weight to be shipped
     * @param weights a list of weights that need to be shipped in order
     * @param d number of days needed to ship
     * @return minimum max daily weight to be shipped
     */
    public static int minMaxWeight(List<Integer> weights, int d) {
        // initialize return value
        int minDailyWeight = -1;

        // get range of possible weights
        int minVal = Collections.max(weights), maxVal = 0;
        for (int weight : weights) maxVal += weight;

        // binary search to find the smallest feasible weight in the range
        while (minVal <= maxVal) {
            // find middle value of the range
            int midVal = minVal + (maxVal - minVal) / 2;
            if (!isFeasible(weights, midVal, d)) minVal = midVal + 1;
            else {
                minDailyWeight = midVal;
                maxVal = midVal - 1;
            }
        }

        return minDailyWeight;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        List<Integer> weights = new ArrayList<>(Arrays.asList(5, 7, 6, 6, 3, 4, 5, 2, 3, 3, 4, 1, 9, 2));
        System.out.println(minMaxWeight(weights, 5));
    }
}
