# 🪙 LeetCode 441: Arranging Coins — Detailed Guide

**Date:** Sunday, July 20, 2025

---

## 📝 Problem Description

Given `n` coins, you are to form them into a staircase structure:

- Row 1 has 1 coin,
- Row 2 has 2 coins,
- Row 3 has 3 coins,
- and so on.

Each subsequent row requires one more coin than the previous. If you don't have enough coins to complete a row, the staircase stops.  
**Your task:** Return the number of _complete_ rows that can be formed from `n` coins[1][2][3].

### Example

| n   | Complete Rows | Reason                                                             |
| --- | :------------ | :----------------------------------------------------------------- |
| 5   | 2             | Rows: 1 (1), 2 (2); left: 2 coins, can't complete row 3 (3)        |
| 8   | 3             | Rows: 1 (1), 2 (2), 3 (3); left: 2 coins, can't complete row 4 (4) |

---

## 🧠 Intuition and Observations

- The number of coins needed for `k` rows is the sum of the first `k` natural numbers:
  - `1 + 2 + ... + k = k * (k + 1) / 2` (a triangular number)[1][3][5].
- The problem reduces to:  
  _What is the largest integer `k` such that_  
  `k * (k + 1) / 2 ≤ n`?

This is a classic **search for max `k`** kind of problem. Two practical solutions exist: **binary search** (algorithmic) and a **direct math formula** (analytical)[1][3].

---

## 🔎 Solution 1: Binary Search Approach

**Why Binary Search?**  
Every time we check a candidate `mid`, we can quickly determine whether we can complete `mid` rows by computing `mid * (mid + 1) / 2`.

- If it uses fewer coins than `n`, try more rows.
- If it uses more, try fewer rows[1][5].

**Algorithm Steps:**

1. Set `left = 0`, `right = n`.
2. While `left <= right`:
   - Set `mid = left + (right - left) // 2`.
   - Compute `coinsNeeded = mid * (mid + 1) / 2`.
   - If exactly `n`, return `mid`.
   - If fewer than `n`, shift search to higher rows (`left = mid + 1`).
   - If more, shift to lower rows (`right = mid - 1`)[1].
3. At the end, `right` is the maximum number of complete rows.

**Java Implementation:**

```java
class Solution {
public int arrangeCoins(int n) {
int left = 0, right = n;
while (left <= right) {
int mid = left + (right - left) / 2;
long coinsNeeded = (long) mid * (mid + 1) / 2;
if (coinsNeeded == n) {
return mid;
} else if (coinsNeeded < n) {
left = mid + 1;
} else {
right = mid - 1;
}
}
return right;
}
}
```

- **Note:** Use `long` for `coinsNeeded` to avoid integer overflow![1][3][5]

---

## 📐 Solution 2: Mathematical Formula

The sum for `k` complete rows is `k * (k+1)/2 ≤ n`.  
This gives the quadratic equation:  
\(k^2 + k - 2n = 0\)

Solving for positive `k`:
\[
k = \frac{-1 + \sqrt{1 + 8n}}{2}
\]

**Java Implementation:**
class Solution {
public int arrangeCoins(int n) {
return (int)((-1 + Math.sqrt(1 + 8.0 \* n)) / 2);
}
}

- **Advantage:** Constant time (but could have floating point rounding issues for very large `n`)
- **Origin:** Directly derives from algebraic manipulation of the triangular number sum[3][9].

---

## ⏱ Complexity Analysis

| Solution      | Time Complexity | Space Complexity | Remarks                           |
| ------------- | --------------- | ---------------- | --------------------------------- |
| Binary Search | O(log n)        | O(1)             | Algorithmically robust            |
| Math Formula  | O(1)            | O(1)             | May incur slight FP errors (rare) |

---

## 💡 Real-World Applications

- **Budget allocation:** Funding projects with growing costs.
- **Resource distribution:** Assigning resources that require more each time[1].
- **Game design:** Calculating max levels achievable with increasing costs/requirements[1][3].

---

## ✅ Example Test Cases

| n   | Result | Explanation                  |
| --- | ------ | ---------------------------- |
| 1   | 1      | Only row 1 can be completed  |
| 5   | 2      | Rows 1 and 2, can't start 3  |
| 6   | 3      | Rows 1, 2, 3 fully completed |
| 8   | 3      | Rows 1, 2, 3; 2 coins remain |
| 15  | 5      | Rows 1..5, can't start 6     |
| 0   | 0      | No rows can be completed     |

---

## 📚 References

- Educative: [Arranging Coins LeetCode][1]
- AlgoMonster: [In-Depth Explanation][3]
- LeetCode Problem: [Arranging Coins][2]

---

**Summary:**  
"Arranging Coins" challenges you to find how many full staircase rows you can make with a given number of coins, using either a binary search or a math formula based on triangular numbers for optimal efficiency.

[1]: https://www.educative.io/answers/arranging-coins-leetcode
[2]: https://leetcode.com/problems/arranging-coins/
[3]: https://algo.monster/liteproble
