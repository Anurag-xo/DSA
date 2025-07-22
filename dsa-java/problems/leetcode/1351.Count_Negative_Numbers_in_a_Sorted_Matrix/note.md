# LeetCode 1351: Count Negative Numbers in a Sorted Matrix

## Problem

Given an `m x n` matrix `grid` which is sorted in non-increasing order **both row-wise and column-wise**, return **the number of negative numbers in the matrix**.

- Each row is sorted from left to right in decreasing order.
- Each column is sorted from top to bottom in decreasing order.

---

**Example 1:**

Input: grid = [
[4, 3, 2, -1],
[3, 2, 1, -1],
[1, 1, -1, -2],
[-1, -1, -2, -3]
]
Output: 8

Explanation: There are 8 negative numbers in the matrix.

text

**Example 2:**

Input: grid = [
,

]
Output: 0

text

---

**Constraints:**

- `1 <= m, n <= 100`
- `-100 <= grid[i][j] <= 100`

---

## Approach

The matrix's sorting allows us to count negatives efficiently:

1. **Start at the bottom-left corner** of the matrix.
2. **If the current value is negative:**
   - All numbers to the right in that row are also negative (row is sorted).
   - Count all negatives in the row from this column onward with: `(number_of_columns - current_column_index)`.
   - Move up one row.
3. **If the current value is non-negative:**
   - Move to the next column (right).

**Time Complexity:** O(m + n)  
**Space Complexity:** O(1)

---

## Java Solution

```java
class Solution {
public int countNegatives(int[][] grid) {
int m = grid.length;
int n = grid.length;
int row = m - 1, col = 0;
int count = 0;

text
while (row >= 0 && col < n) {
if (grid[row][col] < 0) {
count += (n - col);
row--;
} else {
col++;
}
}
return count;
}
}

```

---

## Explanation of Each Step

- `int m = grid.length;`  
  Get the number of rows.

- `int n = grid[0].length;`  
  Get the number of columns.

- `int row = m - 1, col = 0;`  
  Start traversal from the **bottom-left cell**.

- `int count = 0;`  
  Initialize the counter.

- `while (row >= 0 && col < n)`  
  Loop until we move above the matrix (`row < 0`) or past the rightmost column (`col >= n`).
  - **If `grid[row][col] < 0`:**
    - All values from this column to the right in the current row are negative.
    - Add their count: `count += (n - col)`
    - Move up (`row--`).

  - **Else:**
    - Value is not negative; move right (`col++`).

- `return count;`  
  Return the total count of negative numbers.

---

## Test Cases

| Input                                               | Output |
| --------------------------------------------------- | ------ |
| `[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]` | 8      |
| `[[3,2],[1,0]]`                                     | 0      |
| `[[-1]]`                                            | 1      |
| `[[1,-1],[-1,-2]]`                                  | 3      |

---

## Visualization

Consider the first example:

[
[ 4, 3, 2, -1],
[ 3, 2, 1, -1],
[ 1, 1, -1, -2],
[-1, -1, -2, -3]
]

text

Traversal starts at the bottom-left (`row = 3, col = 0`).

- For each negative found, all elements to the right are negative and counted at once.
- If not negative, move right.

This uses the sorted property to avoid checking every element one by one.

---

**Related Topics:** Arrays, Matrix, Binary Search  
**LeetCode:** [1351. Count Negative Numbers in a Sorted Matrix](https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/)
