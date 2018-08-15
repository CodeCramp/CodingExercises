package com.tools;

import java.util.Arrays;

/**
 * Illustrates Kadane's algorithm to find maximum sum of a contiguous sub-array.
 */
public class MaxSumSubArray {

  public static void main(String[] args) {
    int[] a1 = {-1, 2, -2, 3};
    int[] a2 = {-2, -3, 4, -1, -2, 1, 5, -3};

    MaxSumSubArray mssa = new MaxSumSubArray();
    System.out.println("Given: " + Arrays.toString(a1) + "\nMaxSum: " + mssa.findMaxSum(a1)
        + "\nMaxSumSubArray: " + Arrays.toString(mssa.findMaxSumSubArray(a1)));
    System.out.println("\n\nGiven: " + Arrays.toString(a2) + "\nMaxSum: " + mssa.findMaxSum(a2)
        + "\nMaxSumSubArray: " + Arrays.toString(mssa.findMaxSumSubArray(a2)));
  }

  private int findMaxSum(int[] a) {
    if (a == null || a.length == 0) {
      return -1;
    } else if (a.length == 1) {
      return a[0];
    }

    int curr_max = 0;
    int global_max = 0;

    for (int i = 0; i < a.length; i++) {
      curr_max = Math.max(a[i], curr_max + a[i]);
      global_max = Math.max(global_max, curr_max);
    }
    return global_max;
  }

  private int[] findMaxSumSubArray(int[] a) {
    int[] maxSumSubArray = new int[] {};
    if (a == null || a.length == 0) {
      return maxSumSubArray;
    } else if (a.length == 1) {
      return a;
    }

    int curr_max = 0;
    int global_max = 0;
    int start = 0;
    int end = 0;

    for (int i = 0; i < a.length; i++) {
      if (a[i] >= curr_max + a[i]) {
        start = i;
        end = i;
      }
      if (curr_max < global_max) {
        end = i;
      }
      curr_max = Math.max(a[i], curr_max + a[i]);
      global_max = Math.max(global_max, curr_max);
    }

    maxSumSubArray = new int[end - start + 1];
    int j = 0;
    for (int i = start; i <= end; i++) {
      maxSumSubArray[j++] = a[i];
    }

    return maxSumSubArray;
  }
}