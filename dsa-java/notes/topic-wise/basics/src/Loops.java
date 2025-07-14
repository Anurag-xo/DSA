import java.util.Scanner;

public class Loops {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // This will take the input from the user
    int range = sc.nextInt();
    // Print numbers to a specified range.

    // Start of the for loop (initialization)
    for (int num = 1; num <= range; num += 1) {
      System.out.println(num);
    }
    sc.close();
  }
}
