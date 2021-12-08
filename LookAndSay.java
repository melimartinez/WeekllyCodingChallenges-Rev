package dev.martinez.weeklychallenge.Dec08;

import java.util.Arrays;
import java.util.Scanner;

/* Meli Martinez (Melisa) - 12/08/2021
Instructions:
Given an integer value, return a new integer according to the rules below:

-Split the number into groups of two digit numbers. If the number has an odd number of digits, return -1.
-For each group of two digit numbers, concatenate the last digit to a new string the same number of times as the value of the first digit.
-Return the result as an integer.

lookAndSay(3132) ➞ 111222

// By reading the number digit by digit, you get three "1" and three "2".
// Therefore, you put three ones and three two's together.
// Remember to return an integer value (i.e BigIntger class).
Examples:
1) lookAndSay(1213200012171979) ➞ 23002799999999

2) lookAndSay(54544666) ➞ 44444444446666666666

3) lookAndSay(95) ➞ 555555555

4) lookAndSay(1213141516171819) ➞ 23456789

5) lookAndSay(120520) ➞ 200

6) lookAndSay(231) ➞ -1
 */

public class LookAndSay {

    public static void main(String[] args) {
        // declare vars
        Scanner input = new Scanner(System.in);
        long userNum;

        // receive user input
        System.out.println("Hello! Please enter numbers for Look and Say: ");

        userNum = input.nextLong();

        int[] nums = userInputToArray(userNum);
        long result;

        // if the length of array is an even number
        if (nums.length % 2 == 0) {

            // separate user value into two groups
            int [] appearances = findAppearances(nums);
            int[] values = findValues(nums);

            result = lookAndSay(appearances, values);

        }

        // if the length of array is an odd number
        // we cannot continue this process successfully
        // use "-1" to display error to user
        else {
            result = -1;
        }

        System.out.println(result);
    }

    /**
     * Enter two arrays to create a long. The first array will denote
     * how many times a value appears in the result while the second
     * array will define what the actual values being inserted will be.
     * @param appearances int[]
     * @param values int[]
     * @return result long
     */
    public static long lookAndSay(int[] appearances, int[] values) {
        int arrSize = appearances.length;
        long result;
        StringBuilder tempResult = new StringBuilder(arrSize);

        for (int i = 0; i < arrSize; i++) {

            // as many times as the val should appear
            for (int j = 0; j < appearances[i]; j++) {
                tempResult.append(values[i]);   // enter it into the StringBuilder
            }
        }

        // convert String back to Long type
        result = Long.parseLong(tempResult.toString());

        return result;
    }

    /**
     * Turning the long collected from the user into an array.
     * We do this so we can look at each individual integer independently.
     * @param userNum long
     * @return int[]
     */
    public static int[] userInputToArray(long userNum) {

        // convert user's input into a String
        String temp = Long.toString(userNum);

        // create an array that is the size of the String
        int[] arr = new int[temp.length()];

        // enter each individual digit into a separate index of the array
        for (int i = 0; i < temp.length(); i++) {
            arr[i] = temp.charAt(i) - 48;   // "- 48" to offset ASCII value into actual int representation
        }

        // return the array created
        return arr;
    }

    /**
     * Take in the array to separate it into the first group. This
     * group will denote how many times a value appears.
     * @param arr int[]
     * @return int[]
     */
    public static int[] findAppearances(int[] arr) {

        int[] appearancesArr = new int[(arr.length/2)];
        int index = 0;

        // for every other value in the original array
        for (int i = 0; i < arr.length; i+=2) {

            // insert that digit into this group
            appearancesArr[index] = arr[i];
            index++;
        }

        return appearancesArr;
    }

    /**
     * Take in the array to separate it into the second group. This
     * group will denote the values we are adding to our result.
     * @param arr int[]
     * @return int[]
     */
    public static int[] findValues(int[] arr) {

        int[] valuesArr = new int[(arr.length/2)];
        int index = 0;

        // for every other value in the original array
        for (int i = 1; i < arr.length; i+=2) {
            // insert that digit into this group
            valuesArr[index] = arr[i];
            index++;
        }

        return valuesArr;
    }

    // did NOT use this method in the end because I check that it is possible to
    // create two subarrays before I actually make them in order to aboud a
    // "ArrayIndexOutOfBounds" error.
    /**
     * A method that returns whether the two arrays meant to hold the number of appearances
     * and the values that will be represented are the same size. If they are not, that means
     * we cannot properly create a result from the user's values; thus we will return "-1"
     * to denote this error.
     * @param appearances int[]
     * @param values int[]
     * @return boolean
     */
    public static boolean isSameSize(int[] appearances, int[] values) {

        // if the two arrays have the same size
        if (appearances.length == values.length)
            { return true; }

        // if they do not
        else {
            return false;
        }
    }
}
