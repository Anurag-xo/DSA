import java.util.Scanner;

public class Calculator {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int ans = 0;

    // Loop until user presses 'x' or 'X'
    while (true) {
      System.out.print("Enter the operator (+, -, *, /, %, x to exit): ");
      char op = sc.next().trim().charAt(0);

      // Exit condition should be checked first
      if (op == 'x' || op == 'X') {
        System.out.println("Exiting calculator...");
        break;
      }

      // Check if operator is valid
      if (op == '+' || op == '-' || op == '*' || op == '/' || op == '%') {
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        // Perform calculation based on operator
        if (op == '+') {
          ans = num1 + num2;
        } else if (op == '-') {
          ans = num1 - num2;
        } else if (op == '*') {
          ans = num1 * num2;
        } else if (op == '/') {
          if (num2 != 0) {
            ans = num1 / num2;
          } else {
            System.out.println("Cannot divide by zero.");
            continue; // skip printing result
          }
        } else if (op == '%') {
          if (num2 != 0) {
            ans = num1 % num2;
          } else {
            System.out.println("Cannot modulo by zero.");
            continue; // skip printing result
          }
        }

        // Print the result
        System.out.println("Result: " + ans);

      } else {
        System.out.println("Invalid operation, Please try again!!");
      }
    }

    sc.close();
  }
}
