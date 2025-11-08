Here’s a clean, well-structured **`notes.md`** you can include alongside your Java code for **LeetCode Problem 704 – Binary Search**.
It’s written in a professional format that’s easy to keep in your GitHub repository or study notes 👇

---

## 🧠 LeetCode 704 – Binary Search

### 🗂️ Problem Statement

Given a **sorted array of integers** `nums` (in ascending order) and an integer `target`,
return the **index** of `target` if it exists in `nums`.
Otherwise, return `-1`.

You must write an algorithm with **O(log n)** runtime complexity.

---

### 📘 Example

#### Example 1

```
Input: nums = [-1, 0, 3, 5, 9, 12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4.
```

#### Example 2

```
Input: nums = [-1, 0, 3, 5, 9, 12], target = 2
Output: -1
Explanation: 2 does not exist in nums, so return -1.
```

---

### ⚙️ Constraints

- `1 <= nums.length <= 10⁴`
- `-10⁴ < nums[i], target < 10⁴`
- All integers in `nums` are **unique**
- `nums` is sorted in **ascending order**

---

## 🧩 Intuition

Since the array is sorted, we can apply the **Binary Search algorithm**.
Instead of scanning the array linearly (O(n)), binary search divides the search range by half in each step (O(log n)).

---

## 🔍 Algorithm Steps

1. Initialize two pointers:
   - `left = 0` (start index)
   - `right = nums.length - 1` (end index)

2. While `left <= right`:
   - Compute the middle index:

     ```
     mid = left + (right - left) / 2
     ```

     (This prevents integer overflow compared to `(left + right) / 2`)

   - If `nums[mid] == target` → return `mid`
   - Else if `nums[mid] < target` → move to the right half → `left = mid + 1`
   - Else → move to the left half → `right = mid - 1`

3. If the loop ends without finding the target → return `-1`

---

## 💻 Java Implementation

```java
class Solution {
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2; // Prevents overflow

      if (nums[mid] == target) {
        return mid; // Target found
      } else if (nums[mid] < target) {
        left = mid + 1; // Search right half
      } else {
        right = mid - 1; // Search left half
      }
    }
    return -1; // Target not found
  }
}
```

---

## 🧮 Complexity Analysis

| Type                 | Complexity | Explanation                            |
| -------------------- | ---------- | -------------------------------------- |
| **Time Complexity**  | `O(log n)` | Each iteration halves the search space |
| **Space Complexity** | `O(1)`     | Only constant extra variables used     |

---

## 🧠 Key Points to Remember

- Always use **`while (left <= right)`** (not `<`) — otherwise you might skip the last element.
- Use **`left + (right - left) / 2`** to prevent integer overflow.
- Works only when the array is **sorted**.
- The array must contain **unique** elements (as per problem constraint).

---

## 🧰 Example Dry Run

Input:
`nums = [-1, 0, 3, 5, 9, 12]`, `target = 9`

| Step | left | right | mid | nums[mid] | Action                  |
| ---- | ---- | ----- | --- | --------- | ----------------------- |
| 1    | 0    | 5     | 2   | 3         | target > 3 → move right |
| 2    | 3    | 5     | 4   | 9         | target == 9 → return 4  |

✅ Output → **4**

---

## 🏁 Summary

- **Binary Search** efficiently finds an element in a sorted list.
- Reduces time complexity from **O(n)** → **O(log n)**.
- Commonly used in searching, optimization, and sorted data problems.

---
