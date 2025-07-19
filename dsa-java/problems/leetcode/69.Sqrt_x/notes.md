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
   - If `mid*mid < x` → root is higher, move right.
   - If `mid*mid > x` → root is lower, move left.
3. Track the **last mid value whose square is less than or equal to `x`** (for rounding down).

---

## 📝 Solution Code (Java)

public class SqrtSolution {
public static int mySqrt(int x) {
if (x < 2) return x; // 0 and 1 are trivial

text
int left = 1, right = x / 2, ans = 0;
while (left <= right) {
int mid = left + (right - left) / 2;

        long square = (long) mid * mid; // Prevent overflow

        if (square == x) {
            return mid;
        } else if (square < x) {
            ans = mid;      // mid is a possible answer
            left = mid + 1; // move right
        } else {
            right = mid - 1; // move left
        }
    }
    return ans; // Biggest integer whose square <= x

}

public static void main(String[] args) {
int x = 8;
System.out.println("Sqrt(" + x + ") = " + mySqrt(x)); // Output: 2
}
}

text

---

## 🚩 Key Notes

- Always cast to `long` when doing `mid*mid` to avoid integer overflow.
- The loop maintains the invariant: `ans` is the greatest integer such that `ans*ans <= x`.
- Handles edge cases: `x = 0` and `x = 1`.
- Runs in **O(log x)** time.

---

## 🧩 Example Trace

Let’s walk through `x = 8`:

1. `left=1`, `right=4`, `ans=0`
2. `mid=2`, `2*2 = 4 < 8` → `ans=2`, `left=3`
3. `mid=3`, `3*3 = 9 > 8` → `right=2`
4. Loop ends (`left=3 > right=2`)
5. Return `ans=2`

---

## ✅ Summary

- Use binary search for an efficient solution.
- Always round **down**.
- Cast to `long` for safety.
- No built-in exponent functions used!

---
