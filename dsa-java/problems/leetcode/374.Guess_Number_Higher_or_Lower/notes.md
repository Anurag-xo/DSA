# Explaining `int res = guess(mid);` in the Guess Number Higher or Lower Problem

**Date:** Sunday, July 20, 2025

---

## Overview

In the [LeetCode 374. Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/) problem, you're tasked with guessing a secret number between `1` and `n` using a given API function. This is a classic use case for algorithms like **binary search**, which you have studied and implemented in Java[1].

---

## What Does `int res = guess(mid);` Do?

This line calls the **predefined `guess(int num)` API** and assigns its returned value to the variable `res`.

### How the `guess` API Works

- **`guess(int num)`** evaluates your guess (`mid`) against the secret number (`pick`).
- It returns:
  - **`0`**: Your guess is correct (`mid == pick`).
  - **`-1`**: Your guess is higher than the secret number (`mid > pick`).
  - **`1`**: Your guess is lower than the secret number (`mid < pick`).

### Role in the Binary Search Algorithm

- The value of `res` determines the next step:
  - If `res == 0`: You've found the correct number; return `mid`.
  - If `res == -1`: The guess is too high; search in the lower half.
  - If `res == 1`: The guess is too low; search in the upper half.

This feedback loop is essential to efficiently narrowing down the search using binary search logic[1].

---

## Code Illustration

```java
int mid = left + (right - left) / 2;
int res = guess(mid);
if (res == 0) {
return mid;
} else if (res < 0) {
right = mid - 1; // Guess is too high
} else {
left = mid + 1; // Guess is too low
}

```

---

## Why Is This Important?

- The call to `guess(mid)` is **how your algorithm interacts with the unknown secret number**.
- It provides the critical directional feedback that binary search needs to quickly and efficiently find the solution in O(log n) time[1].

---

**In summary:**  
`int res = guess(mid);` links your binary search algorithm to the game's feedback, guiding whether you should search higher or lower, ultimately leading you to the correct guess.

---
