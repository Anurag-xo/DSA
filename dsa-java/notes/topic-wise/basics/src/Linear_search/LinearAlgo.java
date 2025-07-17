
public class LinearAlgo {

  public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    //
    int[] nums = {23, 45, 12, 54, 19, -3, 16, -11, 26, 8};
    int target = 19;
    int ans = linearSearch(nums, target);
    System.out.println("the index of the element is: " + ans);
  }

  // Return the index if itme found
  // Otherwirse if the item not found return -1

  static int linearSearch(int[] arr, int target) {
    if (arr.length == 0) {
      return -1;
    }

    // run for loop
    for (int index = 0; index < arr.length; index++) {
      // check for element at every index if it is equal to target.
      int element = arr[index];
      if (element == target) {
        return index;
      }
    }
    // this line will execute if none of the return statements above have executed
    // hence the target not found
    return -1;
  }
}
