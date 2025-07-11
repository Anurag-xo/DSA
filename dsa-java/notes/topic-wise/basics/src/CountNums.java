import java.util.Scanner;

public class CountNums {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the integer: ");
    int n = sc.nextInt();

    System.out.print("Enter the number to count occurences: ");
    int numToCount = sc.nextInt();

    int count = 0;
    while (n > 0) {

      int rem = n % 10;
      if (rem == numToCount) {
        count++;
      }
      n /= 10;
    }
    sc.close();
    System.out.println(count);
  }
}
