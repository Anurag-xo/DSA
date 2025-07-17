public class MaxItemArr {

  public static void main(String[] args) {
    int[] arr = {1, 3, 23, 9, 18};
    System.out.println(max(arr));

    // to reutrn max value in a specified range.
    System.out.println(maxRange(arr, 1, 3)); // (arr, start, end)
  }

  // work on edge cases here, like arrray being null
  static int max(int[] arr) {

    if (end > start) {
      return -1;
    }

    if (arr == null) {
      return -1;
    }

    int maxval = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > maxval) {
        maxval = arr[i];
      }
    }
    return maxval;
  }

  // function to return max value in a specified range
  static int maxRange(int[] arr, int start, int end) {

    if (arr.length == 0) {
      return -1;
    }

    int maxVal = arr[start];
    for (int i = start; i <= end; i++) {
      if (arr[i] > maxVal) {
        maxVal = arr[i];
      }
    }
    return maxVal;
  }
}
