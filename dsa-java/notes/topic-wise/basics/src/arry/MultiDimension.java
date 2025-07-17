import java.util.Arrays;
import java.util.Scanner;

public class MultiDimension {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    /*  we will print this 3 x 3 matrix using 2d array
     * 1 2 3
     * 4 5 6
     * 7 8 9
     */
    // to store directly
    // int[] [] arr = {
    //   {1, 2, 3}, // 0th Indes
    //   {4, 5, 6}, // 1st Index
    //   {7, 8, 9} // 2nd Index -> arr[2] = {6, 7, 8, 9}
    // };

    // to initialize it and take input from the user
    int[][] arr = new int[3][3];
    // [row][col]  and it is not mandatory to add cols we can leave it blank also.

    // Input

    for (int row = 0; row < arr.length; row++) {
      // for each col in every row
      for (int col = 0; col < arr[row].length; col++) {
        arr[row][col] = sc.nextInt();
      }
    }

    // Output

    for (int row = 0; row < arr.length; row++) {
      // for each col in every row
      for (int col = 0; col < arr[row].length; col++) {
        System.out.print(arr[row][col] + " ");
      }
      System.out.println();
    }

    // OR output can be
    for (int row = 0; row < arr.length; row++) {
      System.out.println(Arrays.toString(arr[row]));
    }

    // OR Enhanced for loop
    for (int[] a : arr) {
      System.out.println(Arrays.toString(a));
    }
  }
}
