import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    // Create a map to store number-to-index pairs
    Map<Integer, Integer> numMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      // Check if the complement exists in the map
      if (numMap.containsKey(complement)) {
        // Return the indices if found
        return new int[] {numMap.get(complement), i};
      }

      // Store the current number and its index
      numMap.put(nums[i], i);
    }

    // Return empty array if no solution found (though problem states there is one)
    return new int[] {};
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Step 1: Input the array
    System.out.print("Enter the number of elements in the array: ");
    int n = scanner.nextInt();
    int[] nums = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      nums[i] = scanner.nextInt();
    }

    // Step 2: Input the target
    System.out.print("Enter the target sum: ");
    int target = scanner.nextInt();

    // Step 3: Call the twoSum method
    int[] result = twoSum(nums, target);

    // Step 4: Display the result
    if (result.length == 2) {
      System.out.printf("Indices: [%d, %d]\n", result[0], result[1]);
      System.out.printf("Numbers: %d + %d = %d\n", nums[result[0]], nums[result[1]], target);
    } else {
      System.out.println("No two numbers add up to the target.");
    }

    scanner.close();
  }
}
