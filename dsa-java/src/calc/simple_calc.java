import java.util.Scanner;

public class simple_calc {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String operator;

    while (true) {
      System.out.println("Choose a operator --> (+ - * /): ");
      operator = sc.nextLine();

      // Check if the user enter a valid filed
      if (operator.isEmpty()) {
        System.out.println("You must enter an operator.");
      } else {
        break;
      }
    }

    System.out.println("Enter a number: ");
    double num = sc.nextDouble();

    System.out.println("Enter another number: ");
    double num_2 = sc.nextDouble();

    sc.close();

    if (operator.equals("+")) {
      double addition_result = num + num_2;
      System.out.printf("Your result: %.0f", addition_result);
    } else if (operator.equals("-")) {
      double subtraction_result = num - num_2;
      System.out.printf("Your result: %.1f", subtraction_result);
    } else if (operator.equals("*")) {
      double multiplication_result = num * num_2;
      System.out.printf("Your result: %.1f", multiplication_result);
    } else if (operator.equals("/")) {
      if (num_2 == 0) {
        System.out.print("You cannot divide by 0, try again.");
      } else {
        double division_result = num / num_2;
        System.out.printf("Your result: %1.f", division_result);
      }
    }
  }
}
