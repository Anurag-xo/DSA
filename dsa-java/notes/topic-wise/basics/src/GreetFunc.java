import java.util.Scanner;

public class GreetFunc {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Your Name: ");
    String getName = sc.next();
    String personalised = myGreet(getName);
    System.out.println(personalised);
  }

  static String myGreet(String name) {
    String message = "HEllO " + name;
    return message;
  }
}

/*
 *  return_type name(argumetns) {
 * //body
 * reutn statement;
 *  }
 */
