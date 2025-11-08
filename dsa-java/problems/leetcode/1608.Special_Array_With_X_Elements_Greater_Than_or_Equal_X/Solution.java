class Solution {
  public int specialArray(int[] nums) {
    int n = nums.length;
    int[] count = new int[n + 1]; // count[0..n], values > n go to count[n]
    for (int val : nums) {
      if (val >= n) count[n]++;
      else count[val]++;
    }
    // suffix sum: number of elements >= x
    int suffix = 0;
    for (int x = n; x >= 0; --x) {
      suffix += count[x];
      if (suffix == x) return x;
    }
    return -1;
  }
}
