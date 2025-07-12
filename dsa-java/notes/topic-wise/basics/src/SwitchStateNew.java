import java.util.Scanner;

public class SwitchStateNew {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String fruit = sc.next();

    switch (fruit) {
      case "Mango" -> System.out.println("King of fruits");
      case "Apple" -> System.out.println("A red sweet fruit");
      case "Orange" -> System.out.println("Round fruit");
      case "Grapes" -> System.out.println("Small fruit");
      default -> System.out.println("Please enter a valid fruit");
    }
    sc.close();
  }
}
