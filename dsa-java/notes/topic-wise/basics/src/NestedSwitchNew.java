import java.util.Scanner;

public class NestedSwitchNew {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int empId = sc.nextInt();
    String department = sc.next();

    switch (empId) {
      case 1 -> System.out.println("Anurag Kumar");
      case 2 -> System.out.println("Annu");
      case 3 -> {
        System.out.println("Emp Number 3");
        switch (department) {
          case "IT" -> System.out.println("IT Department");
          case "Management" -> System.out.println("Management Department");
          default -> System.out.println("No department entered");
        }
      }
      default -> System.out.println("Enter correct EmailID!");
    }
    sc.close();
  }
}
