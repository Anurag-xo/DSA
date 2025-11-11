public class Floor {

  public static void main(String[] args) {
    // here the array is sorted in ascending order
    int[] arr = {2, 3, 5, 9, 14, 16, 18};
    int target = 15;
    int ans = binarySearch(arr, target);
    System.out.println(ans);
  }

  // return the index : greatest number >= target
  static int binarySearch(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      // find the middle element
      // int mid = (start + end) / 2; might be possible that (start + end) exceeds the range of
      // integer in java.
      int mid = start + (end - start) / 2;
      // here it will not exceed the integer value while makeing the calculation.

      if (target < arr[mid]) {
        end = mid - 1;
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        // and found
        return mid;
      }
    }
    return end; // this is the only change we need from binary search to get the floor
  }
}
