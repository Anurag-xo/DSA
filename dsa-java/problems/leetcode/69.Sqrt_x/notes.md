# Integer Square Root Without Built-in Functions (Java)

This guide explains how to compute the integer square root of a non-negative integer `x` in Java **without using any built-in exponent or square root functions**.

---

## Problem

Given a non-negative integer `x`, return the **square root of `x` rounded down to the nearest integer**.

- The return value must be non-negative.
- **Do NOT use** any built-in exponent function (e.g., `Math.sqrt`, `pow`, `**`)!

### Example

- Input: `x = 8`
- Output: `2`  
  _Explanation: The square root of 8 is about 2.828. Rounding down gives 2._

---

## 🧠 Approach

### Why Not Linear Search?

You could try all integers from `1` up to `x`, checking if their square is less than or equal to `x`.

- **Time complexity:** O(√n)
- Too slow for large `x` (e.g., 2,147,483,647)

### Efficient Solution: **Binary Search**

1. **Range:** Square root of `x` is always between `1` and `x / 2` (for x > 1).
2. **Binary Search:** Check the middle value:
   - If `mid*mid == x` → mid is the root.
   - If `mid*mid  x` → root is lower, move left.
3. Track the **last mid value whose square is less than or equal to `x`** (for rounding down).

---

## 📝 Solution Code (Java)

```java
public class SqrtSolution {
    public static int mySqrt(int x) {
        if (x  8` → `right=2`
4. Loop ends (`left=3 > right=2`)
5. Return `ans=2`

---

## ✅ Summary

- Use binary search for an efficient solution.
- Always round **down**.
- Cast to `long` for safety.
- No built-in exponent functions used!

---
```
