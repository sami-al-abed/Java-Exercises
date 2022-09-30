/**
 * You've begun working in the one and only Umbristan, and it is part of your job duty to organize newspapers.
 * Every morning, your coworkers will diligently read through the newspapers to examine its contents.
 * It is your job to organize the newspapers into piles and hand them out to your coworkers to read through.
 *
 * Each newspaper is marked with the time it would take to read through its contents.
 * The newspapers are carefully laid out in a line in a particular order that must not be broken when assigning the newspapers.
 * You cannot pick and choose newspapers randomly from the line to assign to a co-worker.
 * Instead, you must take newspapers from a particular subsection of the line, make a pile and give that to a co-worker.
 *
 * What is the minimum amount of time it would take to have your coworkers go through all the newspapers?
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class solves the problem by using binary search
 *
 * Given a list of times it will take to read the papers in order, we can create an initial range of possible times per person.
 * We know that the minimum possible daily time has to be equal to the time of the longest value, so the initial minimum in the range
 * is equal to the largest value in the provided list.
 * We know that the most that anyone can possibly read is all the papers at once, so the initial maximum is equal to the sum of all reading times.
 * We know that the minimum max daily value should be somewhere between these two numbers, therefore we use binary search to find the solution.
 * In each search, we take the middle of max and min values and check if it is possible to divide the papers between the specified number of workers.
 * If it is not possible, we move the minimum value to mid + 1 since we know everything <= mid is not going to work.
 * If it is possible, we save that value and move the max range to mid value - 1 to see if there are smaller values that work as well.
 * We then return the last found possible value.
 *
 * To check if it is possible we have to go through each time and see if it is possible to split the readings per day between the specified number of people
 * but not go over the limited number of people we have.
 * To do this, we have a variable equal to the reading allowance per worker and a variable that will count how many workers it will take to read with the specified time allowance.
 * We go through each time in the array
 * If the time is less than or equal to the current allowance, we subtract that time from the allowance and look at the next time
 * If the time is greater than the current allowance, we increment the number of workers used by 1 and reset the allowance to the given number
 * If the number of workers used is greater than the number of workers allowed, we return false
 * If the number of workers used is less than or equal to the number of workers allowed, we know it is possible to use this allowance and return true
 */
public class Newspapers
{
    /**
     * Function that takes a list of times, a daily time value, and number of workers the time needs to be split between
     * and returns true or false on whether it is possible to read the given papers in the specified time per the number of workers
     * @param readTimes list of read times of papers
     * @param numWorkers number of workers we need to split reading between
     * @param possibleVal value of the time per worker we want to examine
     * @return true or false of whether we can read all the papers between the given number of workers in the time provided
     */
    public static boolean isPossible(List<Integer> readTimes, int numWorkers, int possibleVal) {
        int remainingTime = possibleVal;
        int workers = 1;
        int i = 0;

        while (i < readTimes.size()) {
            if (readTimes.get(i) <= remainingTime) {
                remainingTime -= readTimes.get(i);
                i++;
            } else {
                remainingTime = possibleVal;
                workers++;
            }
        }

        return numWorkers >= workers;
    }

    /**
     * Function used to find the minimum max daily time per worker to read
     * @param readTimes list of read times of papers
     * @param numCoworkers number of workers to read
     * @return minimum max time per worker to read
     */
    public static int newspapersSplit(List<Integer> readTimes, int numCoworkers) {
        // initialize possible time
        int minPossibleTime = -1;

        // get initial range of possible times
        int minVal = Collections.max(readTimes), maxVal = 0;
        for (int time : readTimes) maxVal += time;

        while (minVal <= maxVal) {
            int midVal = minVal + (maxVal - minVal) / 2;
            if (!isPossible(readTimes, numCoworkers, midVal)) minVal = midVal + 1;
            else {
                minPossibleTime = midVal;
                maxVal = midVal - 1;
            }
        }

        return minPossibleTime;
    }

    /**
     * Main function used to test solution
     * @param args array of sequence characters that are passed to the main function on execution
     */
    public static void main(String[] args) {
        List<Integer> weights = new ArrayList<>(Arrays.asList(2873, 2837, 10, 3, 12, 34, 21, 450, 12, 4, 39, 1, 40, 59, 2, 67, 93, 49, 837, 499, 237, 287, 459, 12309, 9249, 94878, 30));
        System.out.println(newspapersSplit(weights, 4));
    }
}
