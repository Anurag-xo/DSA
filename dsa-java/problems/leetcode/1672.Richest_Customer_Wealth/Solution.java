public class Solution {

  public static void main(String[] args) {
    Solution sol = new Solution();

    int[][] accounts = {
      {1, 2, 3},
      {3, 2, 1},
      {4, 3, 1}
    };
    int richest = sol.maximumWealth(accounts);
    System.out.println("Maximum Wealth is: " + richest);
  }

  public int maximumWealth(int[][] accounts) {
    // person = col
    // account = row
    int ans = Integer.MIN_VALUE;
    for (int person = 0; person < accounts.length; person++) {
      // When you start a new col, take a new sum for that row
      int sum = 0;
      for (int account = 0; account < accounts[person].length; account++) {
        sum += accounts[person][account];
      }
      // now we have  sum of accounts of pesron
      // check with overall answer
      if (sum > ans) {
        ans = sum;
      }
    }
    return ans;
  }
}
