## Problem Statement

You are given an array `nums` of non-negative integers. `nums` is considered **special** if there exists a number `x` such that exactly `x` elements in `nums` are greater than or equal to `x`.

- `x` does **not** have to be an element of `nums`.
- If such `x` exists, return it; otherwise return `-1`.
- It can be proven that when `x` exists it is unique.

---

## Examples

**Example 1**

```
Input: nums = [3, 5]
Output: 2
Explanation: exactly two numbers (3 and 5) are >= 2
```

**Example 2**

```
Input: nums = [0, 0]
Output: -1
Explanation: no x satisfies the condition
```

**Example 3**

```
Input: nums = [0, 4, 3, 0, 4]
Output: 3
Explanation: exactly three numbers are >= 3
```

---

## Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 1000`

Because `n <= 100`, simple `O(n log n)` sorting solutions are fast enough. Counting-based `O(n)` solutions are also straightforward.

---

## Intuition

We want an integer `x` (0 ≤ x ≤ n) such that the count of elements `>= x` equals `x`.
Observations:

- `x` cannot exceed `n` (there are only `n` elements).
- If the array is sorted in descending order, and we examine positions `i = 0..n-1`, we can check whether `nums[i] >= i+1` and `nums[i+1] < i+1` (or boundary) to identify `x = i+1`.
- A simple approach: sort the array ascending or descending and scan, or check for each `x` in `0..n` by counting (O(n²) worst-case, but n ≤ 100 so still OK). Sorting + single pass gives `O(n log n)`.

Uniqueness proof sketch: consider the function `f(x) = number of elements >= x`. `f(x)` is non-increasing with `x`. There can be at most one `x` such that `f(x) == x` because two different `x` values would violate monotonicity.

---

## Approaches

### 1) Sort (descending) — `O(n log n)` time, `O(1)` extra space (ignoring sort)

- Sort `nums` in non-increasing order.
- For `i` from `0` to `n-1`, let `x = i + 1`.
  - If `nums[i] >= x` and (i == n-1 or `nums[i+1] < x`), return `x`.

- After the loop, check whether `0` is valid: if `nums[n-1] < 0` would be needed, but since nums elements are non-negative, `x = 0` is valid only if there are `0` elements >= 0 (impossible unless n == 0). For our constraints, just return -1 if nothing found.

### 2) Count-check for x from 0..n — `O(n²)` worst-case but fine for n ≤ 100

- For `x` from `0` to `n`:
  - Count `c = number of elements >= x`.
  - If `c == x` return `x`.

- Return -1 if no `x` matches.

### 3) Bucket / Counting optimization — `O(n)` time

- Because `nums[i]` ≤ 1000 and `n` ≤ 100, clamp values > n to n.
- Build a frequency array `count[0..n]` where values > n are stored in `count[n]`.
- Then compute suffix sums to get `number of elements >= x` in O(n).
- Find `x` with `suffix[x] == x`.

---

## Recommended Java Implementation (sorting approach)

```java
import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        // Sort in non-increasing order
        Arrays.sort(nums);
        // We want descending access, so index from the end
        for (int i = 0; i < n; ++i) {
            int x = i + 1;
            // nums[n - i - 1] is the i-th largest element
            if (nums[n - i - 1] >= x) {
                // If next smaller element is < x (or no next), then exactly x elements >= x
                if (i == n - 1 || nums[n - i - 2] < x) {
                    return x;
                }
            }
        }
        return -1;
    }
}
```

**Why this works:** After sorting ascending, `nums[n - i - 1]` is the i-th largest. When the i-th largest is at least `i+1`, there are at least `i+1` elements ≥ `i+1`. The next element (the (i+1)-th largest) being `< i+1` guarantees there are exactly `i+1` elements ≥ `i+1`.

---

## Alternative Java Implementation (counting x from 0..n)

```java
class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        for (int x = 0; x <= n; ++x) {
            int count = 0;
            for (int val : nums) {
                if (val >= x) count++;
            }
            if (count == x) return x;
        }
        return -1;
    }
}
```

- Simpler to read and reason about.
- Time complexity `O(n^2)` worst-case, but with `n ≤ 100` it's perfectly acceptable.

---

## O(n) Counting (bucket) Java Implementation

```java
class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1]; // count[0..n], values > n go to count[n]
        for (int val : nums) {
            if (val >= n) count[n]++;
            else count[val]++;
        }
        // suffix sum: number of elements >= x
        int suffix = 0;
        for (int x = n; x >= 0; --x) {
            suffix += count[x];
            if (suffix == x) return x;
        }
        return -1;
    }
}
```

- Time `O(n)`, extra space `O(n)`.

---

## Complexity Summary

| Approach           | Time Complexity | Space Complexity |
| ------------------ | --------------- | ---------------- |
| Sort + scan        | O(n log n)      | O(1) (in-place)  |
| Brute x=0..n count | O(n²)           | O(1)             |
| Bucket / Counting  | O(n)            | O(n)             |

Given constraints, sorting or counting methods are both fine; bucket method is best asymptotically.

---

## Edge Cases & Notes

- `x` ranges from `0` to `n`. You must check `x = 0` as well — it would require exactly `0` elements ≥ 0, which never holds when `n > 0` and `nums` are non-negative. So typically `x = 0` is not returned in our input domain unless `n = 0` (but `n >= 1` per constraints).
- Values larger than `n` can be clamped to `n` for counting optimization because any value ≥ `n` contributes to counts for all `x <= n`.
- The returned `x`, if exists, is unique due to monotonicity of the function `f(x) = count of elements >= x`.

---

## Dry Run (sorting version)

`nums = [0, 4, 3, 0, 4]`

- Sort ascending → `[0, 0, 3, 4, 4]`, `n = 5`.
- i = 0 → x = 1 → check `nums[4] = 4 >= 1` and `nums[3] = 4 < 1?` false → continue.
- i = 1 → x = 2 → `nums[3] = 4 >= 2` and `nums[2] = 3 < 2?` false → continue.
- i = 2 → x = 3 → `nums[2] = 3 >= 3` and `nums[1] = 0 < 3?` true → return `3`.

---

## Quick Tips

- For interviews, explain the sorting approach, then mention the `O(n)` bucket optimization if asked about improving complexity.
- When coding the sort approach be careful with indexing if you sort ascending (use `nums[n-1-i]`) or simply sort descending.
- Remember the uniqueness argument briefly if the interviewer asks why you can return as soon as you find `x`.

---

Would you like a ready-to-copy `notes.md` file formatted for your repo (with badges or diagrams), or implementations in other languages (Python, C++, JavaScript, TypeScript) as well?
