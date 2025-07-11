import java.util.Scanner;

public class salIfelse {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Please Enter your salary: ");

    int salary = sc.nextInt();

    if (salary > 50000) {
      System.out.println("Dam bohii you not poor!");
    } else {
      System.out.println("hey broke bhoii.");
    }
    sc.close();
  }
}
