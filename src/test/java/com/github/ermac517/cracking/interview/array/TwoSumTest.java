package com.github.ermac517.cracking.interview.array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TwoSumTest {

  @Test
  public void findsIndicesForExistingPair() {
    int[] numbers = {2, 7, 11, 15};
    int target = 9;

    int[] result = TwoSum.findTwoSum(numbers, target);

    assertNotNull(result);
    assertEquals(2, result.length, "Should return two indices when a pair exists");
    assertTrue(result[0] >= 0 && result[0] < numbers.length);
    assertTrue(result[1] >= 0 && result[1] < numbers.length);
    assertNotEquals(result[0], result[1], "Indices must be different");
    assertEquals(target, numbers[result[0]] + numbers[result[1]]);
  }

  @Test
  public void returnsEmptyWhenNoPair() {
    int[] numbers = {1, 2, 3, 4};
    int target = 100;

    int[] result = TwoSum.findTwoSum(numbers, target);

    assertNotNull(result);
    assertEquals(0, result.length, "Should return empty array when no pair sums to target");
  }

  @Test
  public void handlesNegativeNumbersAndZero() {
    int[] numbers = {-3, 4, 3, 90, 0};
    int target = 0;

    int[] result = TwoSum.findTwoSum(numbers, target);

    assertNotNull(result);
    assertEquals(2, result.length);
    assertEquals(target, numbers[result[0]] + numbers[result[1]]);
  }
}
