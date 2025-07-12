import java.util.Scanner;

public class Dotequals {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String fruit = sc.next();

    // if (fruit.equals("mango")) {
    //   System.out.println("King of fruits");
    // }
    //
    // if (fruit.equals("apple")) {
    //   System.out.println("An apple a day keeps doctors away");
    // }
    //  Instead of using this we can use case statements.
    switch (fruit) {
      case "Mango":
        System.out.println("King of furits");
        break;
      case "Apple":
        System.out.println("A red fruit");
        break;
      case "Orange":
        System.out.println("Round fruit");
        break;
      case "Grapes":
        System.out.println("Small fruit");
      default:
        System.out.println("Please enter a valid fruit");
        break;
    }
    sc.close();
  }
}
