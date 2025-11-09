# 🍬 Fair Candy Swap — LeetCode #888

## 🧩 Problem Statement

Alice and Bob have candy boxes with different total candies.

- `aliceSizes[i]` = number of candies in Alice’s `i`th box
- `bobSizes[j]` = number of candies in Bob’s `j`th box

They want to **exchange one box each** so that **both end up with the same total number of candies**.

Return an array `[x, y]` such that:

- `x` = number of candies Alice gives
- `y` = number of candies Bob gives
- After the swap, their total candies are equal.

It’s guaranteed that at least one valid pair exists.

---

## 🧠 Example

**Input**

```text
aliceSizes = [1, 2]
bobSizes = [2, 3]
```

**Output**

```text
[1, 2]
```

**Explanation**

- Alice’s total = 3
- Bob’s total = 5
- After swapping:
  - Alice gives 1 and gets 2 → new total = 3 - 1 + 2 = 4
  - Bob gives 2 and gets 1 → new total = 5 - 2 + 1 = 4
    ✅ Both have 4 candies now.

---

## 💡 Intuition

Let:

- `sumA` = total candies Alice has
- `sumB` = total candies Bob has

If Alice gives `a` and Bob gives `b`, then:

```
sumA - a + b = sumB - b + a
```

Simplify the equation:

```
2 * (b - a) = sumB - sumA
```

So,

```
b = a + (sumB - sumA) / 2
```

This means:

- For each `a` in Alice’s list, we just need to find a `b` in Bob’s list such that the above condition holds.

---

## 🚀 Approach (O(n) Solution)

1. Compute total sums: `sumA` and `sumB`.
2. Compute `delta = (sumB - sumA) / 2`.
3. Store all Bob’s candy counts in a `HashSet` for O(1) lookup.
4. For each `a` in Alice’s list:
   - Compute `needed = a + delta`
   - If `needed` exists in Bob’s set, return `[a, needed]`.

---

## 🧮 Complexity Analysis

| Type     | Complexity                                        |
| -------- | ------------------------------------------------- |
| ⏱ Time  | **O(n)** (one pass for sums, one pass for lookup) |
| 💾 Space | **O(n)** (for Bob’s HashSet)                      |

---

## 🧰 Java Implementation

```java
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        for (int a : aliceSizes) sumA += a;
        for (int b : bobSizes) sumB += b;

        int delta = (sumB - sumA) / 2; // Difference that must be compensated
        Set<Integer> bobSet = new HashSet<>(bobSizes.length);
        for (int b : bobSizes) bobSet.add(b);

        for (int a : aliceSizes) {
            int needed = a + delta;
            if (bobSet.contains(needed)) {
                return new int[] { a, needed };
            }
        }
        return new int[0]; // Problem guarantees a solution exists
    }
}
```

---

## 🧩 Example Walkthrough

For:

```text
aliceSizes = [1, 1]
bobSizes   = [2, 2]
```

- sumA = 2, sumB = 4
- delta = (4 - 2) / 2 = 1
- For a = 1 → need b = 1 + 1 = 2 → ✅ exists in Bob’s set

Answer → `[1, 2]`

---

## 🏁 Alternative (O(n log n) Approach)

If extra space is not allowed:

1. Sort both arrays.
2. Use two pointers to find a and b such that `b - a = delta`.

Trade-off: less space, but slower due to sorting.

---

## 🧠 Key Takeaways

- Simple math observation reduces problem to a single-pass lookup.
- Use of `HashSet` provides efficient `O(1)` membership testing.
- Elegant mix of arithmetic reasoning and hashing.

---

### 🏷 Tags

`#Hashing` `#Math` `#TwoPointers` `#Greedy` `#O(n)` `#LeetCode888`

---
