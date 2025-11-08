package com.github.ermac517.cracking.interview.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  /**
   * Finds indices of two numbers that sum to the target value
   *
   * @param numbers array with numbers
   * @param targetSum target sum value
   * @return array with the indices of two numbers that sum to the target value
   */
  public static int[] findTwoSum(int[] numbers, int targetSum) {
    int[] result = new int[0];

    if (numbers != null && numbers.length > 1) {
      Map<Integer, Integer> numMap = new HashMap<>();

      for (int i = 0; i < numbers.length; i++) {
        int complement = targetSum - numbers[i];

        if (numMap.containsKey(complement)) {
          result = new int[] {numMap.get(complement), i};
          break;
        }

        numMap.put(numbers[i], i);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] numbers = {2, 7, 11, 15};
    int targetSum = 9;

    int[] result = findTwoSum(numbers, targetSum);

    if (result.length == 2) {
      System.out.println("Found sum at indices: " + result[0] + ", " + result[1]);
      System.out.println("Numbers are: " + numbers[result[0]] + ", " + numbers[result[1]]);
    } else {
      System.out.println("No two numbers found that sum to " + targetSum);
    }
  }
}
