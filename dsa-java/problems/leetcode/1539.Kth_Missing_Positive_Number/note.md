# 🟢 LeetCode 1539: Kth Missing Positive Number — Binary Search Solution

**Date:** Sunday, July 20, 2025

---

## 📝 Problem Statement

Given a strictly increasing array of positive integers `arr` and an integer `k`, return the **kth positive integer that is missing** from `arr`.

- The list is sorted and has no duplicates.
- You want to find the kth smallest positive number not in the list.

---

## ✨ Binary Search Approach

**Key Insight:**  
For any index `i`, the number of missing numbers up to `arr[i]` is `arr[i] - (i + 1)`.  
We want the **smallest index** where this 'missing count' is greater than or equal to `k`.

### **Algorithm Steps**

1. **Initialize:**
   - `left = 0`, `right = arr.length - 1`

2. **Binary Search:**
   - While `left <= right`:
     - Calculate `mid = left + (right - left) / 2`
     - Calculate `missing = arr[mid] - (mid + 1)`
     - If `missing < k`: move to the right (`left = mid + 1`)
     - Else: move to the left (`right = mid - 1`)

3. **Result:**
   - After the loop, `left` is the minimal index such that kth missing comes before or at `left`
   - **Formula:** `k + left` is the answer

### **Why Does This Work?**

- Missing count at index `i`: `arr[i] - (i + 1)`
- If not enough missing numbers up to `mid`, answer must be after `mid`
- If enough or more than enough are missing, search the left
- `left` ends up at the exact position where kth missing would be inserted

---

## 🚀 Java Implementation

```java
class Solution {
public int findKthPositive(int[] arr, int k) {
int left = 0, right = arr.length - 1;
while (left <= right) {
int mid = left + (right - left) / 2;
int missing = arr[mid] - (mid + 1);
if (missing < k) {
left = mid + 1;
} else {
right = mid - 1;
}
}
return k + left;
}
}
```

---

## 🔍 Example Walkthrough

**Input:**  
arr = `[2, 3, 4, 7, 11]`, k = 5  
**Missing sequence:** 1, 5, 6, 8, 9, 10, 12, ..  
**Output:** 9 (The 5th missing is 9)

---

## 💡 Complexity

- **Time:** O(log n) — efficient for large arrays
- **Space:** O(1)

---

## ✅ Summary Table

| Input Array  | k   | Output | Explanation                      |
| ------------ | --- | ------ | -------------------------------- |
| [2,3,4,7,11] | 5   | 9      | 1,5,6,8,9 → The 5th missing is 9 |
| [1,2,3,4]    | 2   | 6      | 5,6 → The 2nd missing is 6       |
| [2]          | 1   | 1      | Only 1 is missing                |

---

## 🧠 Why Use Binary Search Here?

- Much faster than a linear scan (especially for large `arr` and large `k`).
- Elegant and leverages the sorted property of the input array.
- Uses the math: `missing = arr[i] - (i+1)` to guide the search.

---

## 📚 References

- [LeetCode 1539: Kth Missing Positive Number](https://leetcode.com/problems/kth-missing-positive-number/)
- [LeetCode Binary Search Patterns](https://leetcode.com/explore/learn/card/binary-search/)

--
