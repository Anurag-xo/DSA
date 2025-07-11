import java.util.Scanner;

public class Sum {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int num1 = input.nextInt();
    int num2 = input.nextInt();

    int sum = num1 + num2;

    System.out.println("Sum = " + sum);

    int num3 = input.nextInt();
    int num4 = input.nextInt();

    int sub = num3 - num4;

    System.out.println("Sub = " + sub);
  }
}
