public class Solution {

  public int firstBasVersion(int n) {
    int left = 1;
    int right = n;
    while (left < right) {
      int mid = left + (right - left) / 2; // Avoid overflow
      if (isBasVersion(mid)) {
        right = mid; // mid might be the first basd, so keep it
      } else {
        left = mid + 1; // mid is good; first bad is after mid
      }
    }
    // Now left == right, and it points to first bad version
    return left;
  }
}
