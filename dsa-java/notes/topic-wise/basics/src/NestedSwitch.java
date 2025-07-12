import java.util.Scanner;

public class NestedSwitch {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int empId = sc.nextInt();
    String department = sc.next();

    switch (empId) {
      case 1:
        System.out.println("Anurag Kumar");
        break;
      case 2:
        System.out.println("Annu");
        break;
      case 3:
        switch (department) {
          case "IT":
            System.out.println("IT department");
          case "Management":
            System.out.println("Management Department");
            break;
          default:
            System.out.println("No Department entered");
        }
        break;
      default:
        System.out.println("Enter correct EmpId");
    }
  }
}
