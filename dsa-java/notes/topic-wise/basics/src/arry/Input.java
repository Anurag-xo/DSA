import java.util.Arrays;
import java.util.Scanner;

public class Input {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Array of primitives
    int[] arr = new int[5];
    arr[0] = 23;
    arr[1] = 45;
    arr[2] = 233;
    arr[3] = 543;
    arr[4] = 3;
    System.out.println(arr[3]);

    // Input using for loops
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }

    // Print output  using for loops
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i] + " ");
    }

    // Enhanced for loop
    // for (int num: arr) { //for every element in the array, print the element
    //   System.err.println(num + " "); // here num reprsents element of the array.
    // }

    // Another method for the same
    System.out.println(Arrays.toString(arr)); // best one to print

    // array of objects
    String[] str = new String[4];
    for (int i = 0; i < str.length; i++) {
      str[i] = in.next();
    }

    System.out.println(Arrays.toString(str));
    
    // to modify the elemtne in the array
    str[1] = "Anurag";
  }
}
