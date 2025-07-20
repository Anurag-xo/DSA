# 🅻 Next Greatest Letter (LeetCode 744) — Detailed Guide

## 📝 Problem Description

Given a sorted array of characters `letters` (sorted **non-decreasingly**) and a character `target`, return the **smallest character in `letters` that is lexicographically greater than `target`**.

- If such a character does not exist, return the **first character** in `letters` (array is **circular**).

### Examples

**Example 1:**  
_Input:_ `letters = ["c","f","j"]`, `target = "a"`  
_Output:_ `"c"`

**Example 2:**  
_Input:_ `letters = ["c","f","j"]`, `target = "c"`  
_Output:_ `"f"`

**Example 3:**  
_Input:_ `letters = ["x","x","y","y"]`, `target = "z"`  
_Output:_ `"x"`

---

## 🧠 Approach

The sorted property of the array lets us use **binary search** for efficient O(log n) time complexity.

**Steps:**

1. Set `left = 0`, `right = letters.length - 1`.
2. Binary search:
   - If `letters[mid]` > `target`, search left.
   - Else, search right.
3. After the loop, `left` is the index of the smallest character greater than `target`.
4. Use `left % letters.length` to handle wrap-around if `target` is at least as large as every element.

---

## 🚀 Java Implementation

```java
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
    int left = 0, right = letters.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (letters[mid] <= target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    // Wrap around using modulo for circular array behavior
    return letters[left % letters.length];
   }
}
```

---

## 🔎 Why Does This Work?

- Binary search efficiently finds the point where a character greater than `target` first occurs.
- If all characters are less than or equal to `target`, `left` becomes `letters.length` and the modulo returns `letters[0]`.

---

## 💡 Example Walkthrough

**letters = ['c', 'f', 'j'], target = 'c'**

- `mid = 1` (`'f'`) > `'c'` → move right to `mid - 1 = 0`
- `mid = 0` (`'c'`) <= `'c'` → move left to `mid + 1 = 1`
- Loop ends with `left=1`, which is `'f'`

---

## ⚙️ Complexity

- **Time Complexity:** O(log n)
- **Space Complexity:** O(1)

---

## 🔗 References

- [LeetCode 744: Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)
- [Binary Search - LeetCode Explore](https://leetcode.com/explore/learn/card/binary-search/)

---

## 🏁 Summary

- Use **binary search** for fast lookup in sorted data.
- Handle the **circular** case with modulo operation.
- Elegant and robust for all edge cases.

---
