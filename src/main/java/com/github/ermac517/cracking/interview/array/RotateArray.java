package com.github.ermac517.cracking.interview.array;

import java.util.Arrays;
import java.util.Scanner;

/** Class for solving array rotation problems */
public class RotateArray {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    // Get rotation
    System.out.print("Enter rotation: ");
    int k;
    k = Integer.parseInt(in.nextLine());

    // Get array length
    System.out.print("Enter length: ");
    int l;
    l = Integer.parseInt(in.nextLine());

    // Get array contents
    int[] numbers = new int[l];
    for (int i = 0; i < l; i++) {
      System.out.print("Enter value[" + i + "]: ");
      numbers[i] = Integer.parseInt(in.nextLine());
    }

    int[] copyNumbers = Arrays.copyOf(numbers, numbers.length);

    // Print array
    System.out.print("Original array: ");
    printArray(numbers);

    // Print rotated array to the left
    System.out.print("Left rotated array (additional array): ");
    printArray(leftRotationAdditionalArray(numbers, k));

    System.out.print("Left rotated array (in place): ");
    printArray(rotationInPlace(numbers, k, "left"));

    // Copy original array
    numbers = Arrays.copyOf(copyNumbers, copyNumbers.length);

    // Print rotated array to the right
    System.out.print("Right rotated array (additional array): ");
    printArray(rightRotationAdditionalArray(numbers, k));

    System.out.print("Right rotated array (in place): ");
    printArray(rotationInPlace(numbers, k, "right"));

    in.close();
  }

  /**
   * Print array contents
   *
   * @param numbers array to print
   */
  public static void printArray(int[] numbers) {
    if (numbers != null) {
      for (int i = 0; i < numbers.length; i++) {
        System.out.print(numbers[i] + " ");
      }
    }
    System.out.println("");
  }

  /**
   * Rotates the array right using and additional array
   *
   * @param numbers array to rotate
   * @param k number of positions to rotate to the right
   * @return rotated array to the right
   */
  public static int[] rightRotationAdditionalArray(int[] numbers, int k) {
    int[] rotatedNumbers = new int[0];

    if (numbers != null && numbers.length > 0 && k >= 0) {
      rotatedNumbers = new int[numbers.length];

      if (k >= numbers.length) {
        k %= numbers.length;
      }

      for (int i = 0; i < numbers.length; i++) {
        int pos = (i + k) % numbers.length;

        rotatedNumbers[pos] = numbers[i];
      }
    }

    return rotatedNumbers;
  }

  /**
   * Rotates one position to the right
   *
   * @param numbers array to rotate
   * @return rotated array to the right
   */
  public static int[] singleRightRotationInPlace(int[] numbers) {

    if (numbers != null && numbers.length > 0) {
      int temp = numbers[numbers.length - 1];

      for (int i = numbers.length - 1; i > 0; i--) {
        numbers[i] = numbers[i - 1];
      }

      numbers[0] = temp;
    }

    return numbers;
  }

  /**
   * Rotates the array left using and additional array
   *
   * @param numbers array to rotate
   * @param k number of positions to rotate to the left
   * @return rotated array to the left
   */
  public static int[] leftRotationAdditionalArray(int[] numbers, int k) {
    int[] rotatedNumbers = new int[0];

    if (numbers != null && numbers.length > 0 && k >= 0) {
      rotatedNumbers = new int[numbers.length];

      if (k >= numbers.length) {
        k %= numbers.length;
      }

      for (int i = numbers.length - 1; i >= 0; i--) {
        int pos = (i - k) % numbers.length;

        if (pos < 0) {
          pos += numbers.length;
        }

        rotatedNumbers[pos] = numbers[i];
      }
    }

    return rotatedNumbers;
  }

  /**
   * Performs in place rotation to the left or to the right
   *
   * @param numbers Array to rotate
   * @param k number of positions to rotate
   * @param direction either left or right
   * @return Rotated array to the left or right
   */
  public static int[] rotationInPlace(int[] numbers, int k, String direction) {

    if (numbers != null && numbers.length > 0 && k >= 0) {
      if (k >= numbers.length) {
        k %= numbers.length;
      }

      for (int i = 0; i < k; i++) {
        if (direction.equals("left")) {
          singleLeftRotationInPlace(numbers);
        } else if (direction.equals("right")) {
          singleRightRotationInPlace(numbers);
        }
      }
    }

    return numbers;
  }

  /**
   * Rotates one position to the left
   *
   * @param numbers array to rotate
   * @return rotated array to the left
   */
  public static int[] singleLeftRotationInPlace(int[] numbers) {

    if (numbers != null && numbers.length > 0) {
      int temp = numbers[0];

      for (int i = 0; i < numbers.length - 1; i++) {
        numbers[i] = numbers[i + 1];
      }

      numbers[numbers.length - 1] = temp;
    }

    return numbers;
  }
}
