public class Solution {
  // https://leetcode.com/problems/sqrtx/description/
  public static void main(String[] args) {
    int x = 8;
    System.out.println("Square root: " + mySqrt(x));
  }

  static int mySqrt(int x) {
    while (x < 2) {
      return x;
    }

    int left = 1;
    int right = x / 2;
    int ans = 0;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      long square = (long) mid * mid;

      if (square == x) {
        return mid;
      } else if (square < x) {
        ans = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }
}
