public class Solution {

  public int arrangeCoins(int n) {
    int left = 1, right = n;
    int res = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int coinsUsed = (long) mid * (mid + 1) / 2; // K*(K+1)/2
      if (coinsUsed == n) {
        return mid;
      }
      if (coinsUsed < n) {
        res = mid; // mid rows are fully complete
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return res;
  }
}
