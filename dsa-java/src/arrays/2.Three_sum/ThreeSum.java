import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums); // Step:1 Sort the array.

    for (int i = 0; i < nums.length - 2; i++) {
      // Skip duplicates
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];

        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));

          // Skip duplicates for left and right pointers
          while (left < right && nums[left] == nums[left + 1]) left++;
          while (left < right && nums[right] == nums[right - 1]) right--;

          left++;
          right--;
        } else if (sum < 0) {
          left++; // Need a larger number
        } else {
          right--; // Need a larger number
        }
      }
    }
    return result;
  }

  // main
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Step 1: Get array size from user
    System.out.print("Enter the number of elements in the array: ");
    int n = scanner.nextInt();

    // Step 2 : Get array elements form the user
    int[] nums = new int[n];
    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
      nums[i] = scanner.nextInt();
    }

    // Step 3: Find all triplets
    List<List<Integer>> triplets = threeSum(nums);

    // Step 4: Display results
    if (triplets.isEmpty()) {
      System.out.println("No triplets found in the sum to 0.");
    } else {
      System.out.println("Unique tripets that sum to 0:");
      for (List<Integer> triplet : triplets) {
        System.out.println(triplet);
      }
    }
    scanner.close();
  }
}
