# 🔍 LeetCode 35: Search Insert Position — Detailed Guide

## 📝 Problem Statement

Given a sorted array of **distinct integers** and a target value, return **the index if the target is found**. If not, return the index where it would be if it were inserted in order.

- **Requirement:** Must have O(log n) runtime complexity (use binary search).

---

## 💡 Intuition

- The array is sorted, so **binary search** is the natural choice.
- If the exact target is not found, the position where it should be inserted is the location where `left` would end up after the search.

---

## 🚀 Algorithm

1. Start with two pointers: `left = 0`, `right = nums.length - 1`.
2. While `left <= right`:
   - Compute `mid = left + (right - left) / 2`.
   - If `nums[mid] == target`, return `mid`.
   - If `nums[mid] < target`, search to the right (`left = mid + 1`).
   - If `nums[mid] > target`, search to the left (`right = mid - 1`).
3. After the loop, `left` is the correct insert index.

---

## 🧩 Java Implementation

```java
class Solution {
public int searchInsert(int[] nums, int target) {
int left = 0, right = nums.length - 1;
while (left <= right) {
int mid = left + (right - left) / 2;
if (nums[mid] == target) {
return mid;
} else if (nums[mid] < target) {
left = mid + 1;
} else {
right = mid - 1;
}
}
// Not found: 'left' is the insertion index
return left;
}
}
```

---

## 🔎 Example Walkthrough

| nums        | target | Output | Reason                           |
| ----------- | ------ | ------ | -------------------------------- |
| `[1,3,5,6]` | 5      | 2      | 5 exists at index 2              |
| `[1,3,5,6]` | 2      | 1      | 2 would go between 1 and 3       |
| `[1,3,5,6]` | 7      | 4      | 7 would be appended at the end   |
| `[1,3,5,6]` | 0      | 0      | 0 would be inserted at the front |

---

## ⚙️ Complexity

- **Time:** O(log n)
- **Space:** O(1)

---

## 🔗 References

- [LeetCode 35: Search Insert Position](https://leetcode.com/problems/search-insert-position/)

---

## 🏁 Summary

- Use binary search to quickly locate the target or its insertion position.
- When not found, return where `left` ends up.
- This guarantees O(log n) time and is robust for all edge cases in a sorted list.

---
