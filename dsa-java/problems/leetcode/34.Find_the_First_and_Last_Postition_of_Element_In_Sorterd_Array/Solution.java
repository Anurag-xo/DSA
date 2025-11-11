class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] ans = {-1, -1};

    int left = search(nums, target, true);
    int right = search(nums, target, false);

    ans[0] = left;
    ans[1] = right;

    return ans;
  }

  int search(int[] nums, int target, boolean findStartIndex) {
    int ans = -1;
    int left = 0, right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (target < nums[mid]) {
        right = mid - 1;
      } else if (target > nums[mid]) {
        left = mid + 1;
      } else {
        ans = mid;
        if (findStartIndex) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return ans;
  }
}
