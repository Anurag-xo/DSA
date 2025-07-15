import java.util.Arrays; // Imports the Arrays utility class for array operations like toString()

public class VarArgs {
  public static void main(String[] args) {
    // The main method is the entry point of the program

    // Uncomment to test these methods:
    // fun(); // Calls fun() with no arguments (would print an empty array)
    // multiple(2, 3, "Kunal", "Rahul", "dvytsbhusc"); // Calls multiple() with 2 integers and
    // variable string arguments
    // demo(); // Ambiguous here due to method overloading conflict if called without specifying
    // parameter type
  }

  // Method demo() accepting variable number of integers as arguments
  static void demo(int... v) {
    // 'v' is treated as an array of integers
    System.out.println(
        Arrays.toString(v)); // Prints the array using Arrays.toString for readable output
  }

  // Overloaded method demo() accepting variable number of Strings as arguments
  static void demo(String... v) {
    // 'v' is treated as an array of Strings
    System.out.println(Arrays.toString(v)); // Prints the array of strings
  }

  // Method multiple() accepting two integers and a variable number of Strings as additional
  // arguments
  static void multiple(int a, int b, String... v) {
    // Currently empty - you can add logic to process the integers and string array as needed
  }

  // Method fun() accepting variable number of integers as arguments
  static void fun(int... v) {
    System.out.println(Arrays.toString(v)); // Prints the array of integers
  }
}
