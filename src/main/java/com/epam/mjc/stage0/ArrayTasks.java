package com.epam.mjc.stage0;

import java.util.Collections;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"winter", "spring", "summer", "autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] generatedNumbers = new int[length];

        for (int i = 0; i < length; i++) {
            generatedNumbers[i] = i + 1;
        }

        return generatedNumbers;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        int searchResult = -1;

        for (int i = 0; i < arr.length; i++) {
            if (number == arr[i]) {
                searchResult = i;
                break;
            }
        }

        return searchResult;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] reversedArr = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversedArr[arr.length - i] = arr[i];
        }

        return reversedArr;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int[] positiveArr = new int[arr.length];
        int positiveCounter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positiveArr[positiveCounter] = arr[i];
                positiveCounter++;
            }
        }

        return positiveArr;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {

        // Sort all elements in all arrays using bubble sort

        for (int i = 0; i < arr.length; i++) {
            for (int bubbleCounter = 0; bubbleCounter < arr[i].length; bubbleCounter++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (j != 0 && arr[i][j - 1] > arr[i][j]) {

                        // Switching places between arr[i][j - 1] and arr[i][j]
                        // P.S. It is bubble sort realisation based on XOR

                        arr[i][j - 1] = arr[i][j - 1] ^ arr[i][j];
                        arr[i][j] = arr[i][j] ^ arr[i][j - 1];
                        arr[i][j - 1] = arr[i][j - 1] ^ arr[i][j];
                    }
                }
            }
        }

        // Sort all internal arrays by length using bubble sort

        for (int bubbleCounter = 0; bubbleCounter < arr.length; bubbleCounter++) {
            for (int arrCounter = 0; arrCounter < arr.length; arrCounter++) {
                if (arrCounter != 0 && arr[arrCounter - 1].length > arr[arrCounter].length) {

                    int smallLength = arr[arrCounter].length;
                    int bigLength = arr[arrCounter - 1].length;

                    // Buffer arrays
                    int[] smallBuffArr = new int[smallLength];
                    int[] bigBuffArr = new int[bigLength];

                    // Full copy arr[arrCounter - 1] to bigBuffArr
                    System.arraycopy(arr[arrCounter - 1], 0, bigBuffArr, 0, bigLength);

                    // Full copy arr[arrCounter] to smallBuffArr
                    System.arraycopy(arr[arrCounter], 0, smallBuffArr, 0, smallLength);

                    // Replace old arrays with a new swapped copies
                    System.arraycopy(smallBuffArr, 0, arr[arrCounter - 1], 0, arr[arrCounter - 1].length);
                    System.arraycopy(bigBuffArr, 0, arr[arrCounter], 0, arr[arrCounter].length);
                }
            }
        }

        return arr;
    }
}
