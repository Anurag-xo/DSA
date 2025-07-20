class Solution {
  public int findKthPositive(int[] arr, int k) {
    int left = 0, right = arr.length - 1;

    // Binary search for the break point
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int missing = arr[mid] - (mid + 1);
      if (missing < k) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    // The answer is k + left
    return k + left;
  }
}
