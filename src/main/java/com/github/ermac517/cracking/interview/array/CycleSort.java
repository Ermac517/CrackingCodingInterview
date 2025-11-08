package com.github.ermac517.cracking.interview.array;

public class CycleSort {
  public static int[] cycleSort(int[] arr) {
    return cycleSort(arr, false);
  }

  /**
   * Cycle sort with optional verbose tracing.
   *
   * @param arr input array (will be sorted in place)
   * @param verbose when true, prints trace information about each placement
   * @return the sorted array (same reference as input)
   */
  public static int[] cycleSort(int[] arr, boolean verbose) {
    int n = arr.length;

    for (int cycleStart = 0; cycleStart <= n - 2; cycleStart++) {
      int item = arr[cycleStart];

      // Compute the final index `pos` for `item` by counting how many
      // elements to the right of cycleStart are strictly less than `item`.
      // Starting at `pos = cycleStart`, incrementing for every smaller element
      // yields the zero-based index where `item` should reside in the sorted
      // array.
      int pos = cycleStart;
      for (int i = cycleStart + 1; i < n; i++) {
        if (arr[i] < item) {
          pos++;
        }
      }

      // If `pos` equals `cycleStart` the element is already in its correct
      // position and no work is required for this cycle start.
      if (pos == cycleStart) {
        continue;
      }

      // Place `item` into its final position. The value at `arr[pos]` is
      // displaced and becomes the new `item` to place during the following
      // cycle-completion loop. Because we assume distinct elements we do not
      // need to skip over equal values when computing positions.
      if (pos != cycleStart) {
        if (verbose) {
          System.out.println(
              "Initial placement: cycleStart=" + cycleStart + " item=" + item + " -> pos=" + pos);
        }
        int temp = item;
        item = arr[pos];
        arr[pos] = temp;
        if (verbose) {
          System.out.print(" after initial swap: ");
          for (int num : arr) {
            System.out.print(num + " ");
          }
          System.out.println();
        }
      }

      // Traced cycle completion loop:
      // Repeatedly compute the final position for `item`, swap it into place,
      // and continue with the displaced element until we return to cycleStart.
      //
      // This loop:
      // 1) sets pos = number of elements < item (i.e., final index for item)
      // 2) if item not already at arr[pos], swaps item into arr[pos]
      // 3) the displaced value becomes the new item to place
      // 4) repeats until the cycle closes (pos == cycleStart)
      while (pos != cycleStart) {
        pos = cycleStart;

        // recompute final position for current item
        for (int i = cycleStart + 1; i < n; i++) {
          if (arr[i] < item) {
            pos++;
          }
        }

        // Tracing output (if enabled): show which item is being placed and
        // its computed target position. Guarded by `verbose` so tracing can be
        // turned off in production.
        if (verbose) {
          System.out.println(
              "cycleStart=" + cycleStart + " placing item=" + item + " -> pos=" + pos);
        }

        if (item != arr[pos]) {
          int temp = item;
          item = arr[pos];
          arr[pos] = temp;

          // Print array state after the swap when verbose tracing is on.
          if (verbose) {
            System.out.print(" after swap: ");
            for (int num : arr) {
              System.out.print(num + " ");
            }
            System.out.println();
          }
        }
      }
    }

    return arr;
  }

  public static void main(String[] args) {
    System.out.println("CycleSort class");
    // Use a distinct set of values since this implementation assumes no duplicates
    int[] arr = {3, 1, 5, 2, 4};
    System.out.println("Unsorted array: ");
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
    // Run with verbose tracing enabled for demonstration
    int[] sortedArr = cycleSort(arr, true);
    System.out.print("Sorted array: ");
    for (int num : sortedArr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
