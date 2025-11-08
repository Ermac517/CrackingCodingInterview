package com.github.ermac517.cracking.interview.array;

import java.util.Scanner;

/** Class for solving the container with most water problem */
public class ContainerWithMostWater {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Get array length
    System.out.print("Enter length: ");
    int l;
    l = Integer.parseInt(in.nextLine());

    // Get array contents
    int[] heights = new int[l];
    for (int i = 0; i < l; i++) {
      System.out.print("Enter value[" + i + "]: ");
      heights[i] = Integer.parseInt(in.nextLine());
    }

    // Get the area
    System.out.println("Container with most water: " + getMaxArea(heights));

    in.close();
  }

  /**
   * Gets the max area of for a container
   *
   * @param heights array with heights value
   * @return the max area
   */
  public static int getMaxArea(int[] heights) {
    int maxArea = 0;
    int area = 0;

    if (heights != null) {
      int left = 0;
      int right = heights.length - 1;

      while (left < right) {
        area = Math.abs(right - left) * Math.min(heights[left], heights[right]);
        maxArea = Math.max(area, maxArea);

        if (heights[left] < heights[right]) {
          left++;
        } else {
          right++;
        }
      }
    }

    return maxArea;
  }
}
