# 📦 First Bad Version Problem — Detailed Guide

## 🚩 Problem Statement

You're managing a product with version numbers from 1 to n. At some point, a bad version appears, and every version after that is also bad (because each new version is built on top of the previous).  
Your task: **Find the first bad version**.

You are given a helper API:

boolean isBadVersion(int version)

text

which returns `true` if a version is bad and `false` otherwise.

**Goal:**  
Minimize the number of calls to `isBadVersion` and return the smallest version number that is bad.

---

## 🧠 Approach: Binary Search

This is a classic search problem.

- The sequence is **monotonic**: all versions before `first_bad` are good, and all from `first_bad` onward are bad.
- For such problems, **binary search is optimal** (O(log n) calls).

**Key Idea:**  
At every step, check the middle version:

- If `mid` is bad, the first bad version is at `mid` **or before**.
- If `mid` is good, the first bad version is **after** `mid`.

---

## 🚀 Step-by-Step Solution (in Java)

```java
public class Solution extends VersionControl {
public int firstBadVersion(int n) {
int left = 1;
int right = n;
while (left < right) {
int mid = left + (right - left) / 2; // Prevents integer overflow
if (isBadVersion(mid)) {
right = mid; // mid might be the first bad version
} else {
left = mid + 1; // first bad is after mid
}
}
// At the end, left == right == first bad version
return left;
}
}
```

> - **`VersionControl` is the base class provided by the problem (LeetCode, etc.) containing the API.**

---

## 🔍 Example Walk-through

Suppose `n = 5` and `first_bad = 4`  
Versions: 1 2 3 4 5  
isBadVersion: F F F T T

1. `left = 1`, `right = 5`
2. `mid = 3` → isBadVersion(3) = false → search [4,5]
3. `mid = 4` → isBadVersion(4) = true → search [4,4]
4. Now, `left == right == 4`. Done!

---

## 📝 Why This Works

- `left` always points to the smallest possible bad version based on search history.
- When `left == right`, it can only be the very first bad version.
- **No redundant API calls.**

---

## ⚙️ Time Complexity

- **Time:** O(log n) API calls — best possible.
- **Space:** O(1) extra space.

---

## 🛡️ Edge Cases

- The first version (`1`) could be bad.
- No version is good; all are bad (should return 1).
- All are good (theoretically shouldn't happen per constraints).

---

## 🏁 Summary

- Use binary search over the versions.
- Check `mid` and narrow the search space.
- Stop when `left == right`: that's the **first bad version**.

---

## 📚 References

- [LeetCode 278: First Bad Version](https://leetcode.com/problems/first-bad-version/)
- [Binary Search Patterns - LeetCode Explore](https://leetcode.com/explore/learn/card/binary-search/)

---
