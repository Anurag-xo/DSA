# Peak Index in a Mountain Array

## Problem Link

[852. Peak Index in a Mountain Array - LeetCode](https://leetcode.com/problems/peak-index-in-a-mountain-array/)

## Problem Description

You are given an integer array `arr` that is guaranteed to be a **mountain array**.

An array `arr` is a mountain array if and only if:

1.  `arr.length >= 3`
2.  There exists some `i` with `0  arr[i+1] > ... > arr[arr.length - 1]` (strictly decreasing part)

The goal is to return the index `i` of the peak element, which is the element `arr[i]` that is greater than its neighbors.

**Example:**

- Input: `arr = `
- Output: `1` (The peak is `10` at index `1`).

## Solution Approach

The structure of a mountain array—an increasing sequence followed by a decreasing sequence—makes it a perfect candidate for a **Binary Search** algorithm. A linear scan would solve the problem in O(n) time, but we can do better. Binary search will allow us to find the peak in O(log n) time.

The key idea is to use binary search to efficiently narrow down the possible location of the peak. At any given `mid` point, we can determine whether the peak lies to its left or to its right by comparing `arr[mid]` with its right neighbor, `arr[mid + 1]`.

There are two possible scenarios when we inspect `arr[mid]`:

1.  **`arr[mid]  arr[mid + 1]`**: This means we are on the **decreasing slope** of the mountain. `mid` could be the peak itself, or the peak could be to its left. We cannot discard `mid` yet, but we can safely discard everything to the right of `mid`. Therefore, we set `right = mid`.

The loop continues until `left` and `right` converge (`left == right`). At this point, they will both be pointing to the peak index, as it's the only index that is never discarded.

### Walkthrough Example

Let's trace the algorithm with `arr = `.

- **Initial State:** `left = 0`, `right = 3` (`arr.length - 1`)

- **Iteration 1:**
  - `mid = 0 + (3 - 0) / 2 = 1`
  - Compare `arr` and `arr` -> `10 > 5`.
  - This matches our second scenario (`arr[mid] > arr[mid + 1]`). We are on the decreasing slope. The peak is at `mid` or to its left.
  - Update `right = mid`.
  - Now, `left = 0`, `right = 1`.

- **Iteration 2:**
  - `mid = 0 + (1 - 0) / 2 = 0`
  - Compare `arr` and `arr` -> `0 < 10`.
  - This matches our first scenario (`arr[mid] < arr[mid + 1]`). We are on the increasing slope. The peak must be to the right of `mid`.
  - Update `left = mid + 1`.
  - Now, `left = 1`, `right = 1`.

- **Termination:**
  - The `while (left < right)` condition (`1 < 1`) is now `false`. The loop terminates.

- **Return Value:** The function returns `left`, which is `1`. This is the correct index of the peak element `10`.

## Complexity Analysis

- **Time Complexity:** **O(log n)**, where `n` is the number of elements in the array. At each step of the `while` loop, we reduce the search space by half, which is the classic behavior of a binary search.

- **Space Complexity:** **O(1)**. We only use a few variables (`left`, `right`, `mid`) to keep track of indices. The space used is constant and does not depend on the size of the input array.

## Full Java Code

```java
public class Solution {

  /**
   * Finds the peak index in a mountain array using binary search.
   *
   * @param arr The input mountain array.
   * @return The index of the peak element.
   */
  public int peakIndexInMountainArray(int[] arr) {
    int left = 0, right = arr.length - 1;

    // The loop continues as long as our search space has more than one element.
    // When left == right, we have found our peak.
    while (left < right) {
      int mid = left + (right - left) / 2;

      // If mid is on the increasing slope, the peak is to the right.
      if (arr[mid] < arr[mid + 1]) {
        left = mid + 1;
      }
      // If mid is on the decreasing slope (or is the peak), the peak is at mid or to the left.
      else {
        right = mid;
      }
    }

    // At the end of the loop, left and right will converge on the peak index.
    return left;
  }
}
```
