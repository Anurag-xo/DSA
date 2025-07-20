# 🎯 LeetCode 367: Valid Perfect Square — Detailed Guide

## 📝 Problem Description

Given a **positive integer `num`**, return `true` if `num` is a **perfect square**, or `false` otherwise.  
A _perfect square_ is an integer that is the square of another integer, i.e., there exists an integer `x` such that `x * x = num`.

🚫 **Constraint:**  
You **must not use any built-in square root functions** (like `sqrt`).

---

## 🚦 Approach: Binary Search

### Why Binary Search?

- We want to efficiently check if there is some integer `mid` such that `mid * mid == num`.
- Since multiplication is monotonic (increases as mid increases), we can use binary search on the range `[1, num]`.

---

### **Algorithm Steps**

1. Set search boundaries: `left = 1`, `right = num`.
2. While `left <= right`:
   - Let `mid = left + (right - left) / 2`.
   - Calculate `square = mid * mid`.
   - If `square == num`, return `true`.
   - If `square < num`, search higher half (`left = mid + 1`).
   - If `square > num`, search lower half (`right = mid - 1`).
3. If no such `mid` is found, return `false`.

**Tip:**  
Use `long` instead of `int` for `mid` and `square` to avoid integer overflow for large input values.

---

### **Java Implementation**

```java
public class Solution {
public boolean isPerfectSquare(int num) {
if (num < 1) return false;
long left = 1, right = num;

text
    while (left <= right) {
        long mid = left + (right - left) / 2;
        long square = mid * mid;

        if (square == num) {
            return true;
        } else if (square < num) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return false;
}
}

```

---

## 🧪 Example Walkthrough

### Example 1

| Input  | Steps                               | Output |
| ------ | ----------------------------------- | ------ |
| 16     | mid = 8, 4, 2 → find 4\*4=16        | true   |
| 14     | mid = 7 → 49>14; mid = 3 → 9<14 ... | false  |
| 1      | mid = 1 → 1\*1 = 1                  | true   |
| 808201 | mid = 404100, etc... find 899\*899  | true   |

---

## ⏱ Complexity

- **Time:** O(log n) — halves the search space each step.
- **Space:** O(1)

---

## ⚠️ Edge Cases

- `num = 1`: True.
- Large numbers: Uses `long` to prevent overflow.
- Non-squares: Returns false.

---

## 📚 Summary

- **Do not use built-in `sqrt`.**
- Use **binary search** to efficiently check for a perfect square.
- Remember integer overflow considerations for large inputs.

---

## References

- [LeetCode 367. Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)
- [Binary Search Patterns](https://leetcode.com/explore/learn/card/binary-search/)

---
