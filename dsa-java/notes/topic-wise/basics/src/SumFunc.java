import java.util.Scanner;

public class SumFunc {
  public static void main(String[] args) {
    sum();
  }

  static void sum() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number 1: ");
    int num1 = sc.nextInt();

    System.out.print("Enter number 2: ");
    int num2 = sc.nextInt();

    int sum = num1 + num2;
    System.out.println("The Sum is: " + sum);
    sc.close();
  }
}
