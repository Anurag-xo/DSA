import java.util.Scanner; // Importing Scanner class for taking user input

public class PrimeNum {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // Creating a Scanner object to read input from user
    int n = sc.nextInt(); // Reading an integer input and storing it in variable n
    boolean ans =
        isPrime(n); // Calling isPrime() method to check if n is prime, storing result in ans
    System.out.println(ans); // Printing the result: true if prime, false otherwise
  }

  // Method to check whether a given number n is prime
  static boolean isPrime(int n) {
    if (n <= 1) {
      // Numbers less than or equal to 1 are not prime
      return false;
    }
    int c = 2; // Initializing divisor c to 2 (smallest prime)

    // Loop runs while c*c <= n to check for factors only up to sqrt(n)
    while (c * c <= n) {
      if (n % c == 0) {
        // If n is divisible by c, it's not prime
        return false;
      }
      c++; // Increment c to check next divisor
    }

    // If no divisors found, n is prime
    // Returns true if loop completed without finding any divisor
    return c * c > n;
  }
}
