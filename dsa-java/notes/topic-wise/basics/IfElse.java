import java.util.Scanner;

public class IfElse {

  public static void main(String[] args) {
    // int num = 10;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number: ");

    int num = input.nextInt();

    if (num % 2 == 0) {
      System.out.println(num + "is Even");
    } else {
      System.out.println(num + "is Odd");
    }

    input.close();
  }
}
