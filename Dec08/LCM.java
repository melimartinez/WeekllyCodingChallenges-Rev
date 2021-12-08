package dev.martinez.weeklychallenge.Dec08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* Meli Martinez (Melisa) - 12/08/2021
Instructions:
Create a function that takes an array of more than three numbers and returns the Least Common Multiple (LCM).

Examples:
lcmOfArray([5, 4, 6, 46, 54, 12, 13, 17]) ➞ 2744820

lcmOfArray([46, 54, 466, 544]) ➞ 78712992

lcmOfArray([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]) ➞ 2520

lcmOfArray([13, 6, 17, 18, 19, 20, 37]) ➞ 27965340

Notes:
The LCM of an array of numbers is the smallest positive number that is divisible by each of the numbers in the array.
 */

public class LCM {

    public static void main(String[] args) {

        // declare necessary vars
        Scanner input = new Scanner(System.in);
        List<Integer> userNums = new ArrayList<Integer>();
        boolean addingNumsStatus = true;
        int currentNum;

        // request user to enter their desired nums
        System.out.println("Hello! Please enter numbers to evaluate LCM.\n" +
                            "If you would like to quit, enter `-1`: ");

        while (addingNumsStatus) {

            // if user has entered a number that does not designate
            // that they no longer wish to add to the numbers evaluated
            currentNum = input.nextInt();
            if (currentNum != -1) {
                userNums.add(currentNum);  // add the number
            }

            // if the user no longer wants to add numbers
            else {

                // check that we have at least 3 numbers in array
                if (userNums.size() < 3) {
                    System.out.println("I'm sorry; we need at least 3 numbers to evaluate!\n");
                }

                // if there are, approve request
                else {
                    addingNumsStatus = false;
                }
            }


        }

        // convert ArrayList to Array
        int[] nums = userNums.stream().mapToInt(i -> i).toArray();

        // invoke LCM function
        long lcm = lcmOfArray(nums);

        System.out.println(lcm);
    }

    public static long lcmOfArray(int ... numbers) {

        // initialize vars
        long lcm;
        int indexOfLastNum = numbers.length - 1;


        // sort the array into ascending order
        Arrays.sort(numbers);

        // we want to immediately deduce if the largest num int the array
        // is divisible by the LCM to not waste time checking other
        // smaller nums first
        lcm = numbers[indexOfLastNum];

        System.out.println(lcm);

        for (int i = indexOfLastNum; i > -1; i--) {
            if (!(isDivisible(lcm, numbers[i]))) {
                lcm += numbers[indexOfLastNum];   // add the largest num in array to our LCM
                i = indexOfLastNum; // reset i to iterate through all nums again
            }
        }

        return lcm;
    }

    // check to make sure that the LCM is divisible by a num
    public static boolean isDivisible(long dividend, int divisor) {

        boolean result = (dividend % divisor) == 0;

        return result;
    }
}
