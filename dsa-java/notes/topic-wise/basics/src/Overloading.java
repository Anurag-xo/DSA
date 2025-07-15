public class Overloading {
  public static void main(String[] args) {
    // The main method is the entry point of the program

    // Uncomment below lines to test the overloaded fun() methods:

    // fun(67); // Calls fun() with an integer argument (prints "first one" and the number)
    // fun("Anurag Kumar"); // Calls fun() with a String argument (prints "Second one" and the name)

    int ans = sum(3, 4, 78); // Calls the overloaded sum() method that takes 3 integers
    System.out.println(ans); // Prints the result of the sum (3 + 4 + 78 = 85)
  }

  // Overloaded method sum() that takes two integers as parameters
  static int sum(int a, int b) {
    return a + b; // Returns the sum of a and b
  }

  // Overloaded method sum() that takes three integers as parameters
  static int sum(int a, int b, int c) {
    return a + b + c; // Returns the sum of a, b, and c
  }

  // Overloaded method fun() that takes an integer parameter
  static void fun(int a) {
    System.out.println("first one"); // Indicates this method was called
    System.out.println(a); // Prints the integer passed to the method
  }

  // Overloaded method fun() that takes a String parameter
  static void fun(String name) {
    System.out.println("Second one"); // Indicates this method was called
    System.out.println(name); // Prints the String passed to the method
  }
}
