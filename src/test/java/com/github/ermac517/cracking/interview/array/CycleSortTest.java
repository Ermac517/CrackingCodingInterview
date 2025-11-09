package com.github.ermac517.cracking.interview.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class CycleSortTest {

  @Test
  public void sortsUnsortedDistinctArray() {
    int[] arr = {3, 1, 5, 2, 4};
    int[] expected = {1, 2, 3, 4, 5};

    int[] result = CycleSort.cycleSort(arr.clone());

    assertArrayEquals(expected, result);
  }

  @Test
  public void handlesAlreadySortedArray() {
    int[] arr = {1, 2, 3, 4};

    int[] result = CycleSort.cycleSort(arr.clone());

    assertArrayEquals(arr, result);
  }

  @Test
  public void handlesEmptyAndSingleElement() {
    int[] empty = {};
    int[] single = {42};

    assertArrayEquals(empty, CycleSort.cycleSort(empty.clone()));
    assertArrayEquals(single, CycleSort.cycleSort(single.clone()));
  }
}
