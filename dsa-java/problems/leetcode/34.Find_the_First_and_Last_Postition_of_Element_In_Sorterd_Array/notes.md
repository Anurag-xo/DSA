# 🧩 LeetCode #34: Find First and Last Position of Element in Sorted Array

**Difficulty:** Medium  
**Topic:** Binary Search  
**Tags:** Array, Binary Search

---

## 📝 Problem Statement

Given an array of integers `nums` sorted in **non-decreasing order**, find the **starting** and **ending position** of a given `target` value.

If `target` is **not found** in the array, return `[-1, -1]`.

The algorithm must run in **O(log n)** time complexity.

---

## 🧠 Example

### Example 1:

**Input:**  
`nums = [5,7,7,8,8,10], target = 8`  
**Output:**  
`[3,4]`

### Example 2:

**Input:**  
`nums = [5,7,7,8,8,10], target = 6`  
**Output:**  
`[-1,-1]`

### Example 3:

**Input:**  
`nums = [], target = 0`  
**Output:**  
`[-1,-1]`

---

## ⚙️ Constraints

- `0 <= nums.length <= 10⁵`
- `-10⁹ <= nums[i] <= 10⁹`
- `nums` is sorted in **non-decreasing** order.
- `-10⁹ <= target <= 10⁹`

---

## 💡 Approach (Binary Search)

We use **binary search twice**:

1. Once to find the **first occurrence** (leftmost index).
2. Once to find the **last occurrence** (rightmost index).

Each binary search takes `O(log n)` → total complexity: **O(log n)**.

### Steps:

1. Perform binary search for `target`.
2. When `nums[mid] == target`, store index as potential answer.
   - For **first occurrence**, continue searching in the **left half**.
   - For **last occurrence**, continue searching in the **right half**.
3. Return both indices.

---

## 🧩 Optimized Java Solution

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        int left = search(nums, target, true);
        int right = search(nums, target, false);

        ans[0] = left;
        ans[1] = right;

        return ans;
    }

    private int search(int[] nums, int target, boolean findStartIndex) {
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
                    right = mid - 1;  // move left for first occurrence
                } else {
                    left = mid + 1;   // move right for last occurrence
                }
            }
        }

        return ans;
    }
}
```

---

## 🧮 Time & Space Complexity

| Complexity | Analysis                       |
| ---------- | ------------------------------ |
| **Time**   | O(log n) — two binary searches |
| **Space**  | O(1) — no extra space used     |

---

## 🏁 Key Takeaways

- Use **binary search twice** to get both bounds efficiently.
- Always check sorted array properties before applying binary search.
- Make sure not to return immediately when a match is found — continue searching for boundaries.

---

## ✅ Example Walkthrough

Input: `nums = [5,7,7,8,8,10], target = 8`

| Step | left                | right | mid | nums[mid] | Action                          |
| ---- | ------------------- | ----- | --- | --------- | ------------------------------- |
| 1    | 0                   | 5     | 2   | 7         | target > nums[mid] → move right |
| 2    | 3                   | 5     | 4   | 8         | found → move left (find first)  |
| 3    | 3                   | 3     | 3   | 8         | found → move left → exit        |
| ✅   | **First Index = 3** |       |     |           |                                 |

Repeat for last index → **Rightmost = 4**

**Final Answer:** `[3,4]`

---

## 🧭 Summary

| Parameter        | Value                                                |
| ---------------- | ---------------------------------------------------- |
| **Technique**    | Binary Search (Double)                               |
| **Optimal Time** | O(log n)                                             |
| **Space**        | O(1)                                                 |
| **Edge Cases**   | Empty array, target not found, single-element arrays |

---
