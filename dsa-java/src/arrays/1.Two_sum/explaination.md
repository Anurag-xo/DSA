# **Two Sum Problem - Comprehensive Explanation**

## **1. Problem Statement**

Given an array of integers `nums` and an integer `target`, return the **indices** of the two numbers that add up to the target.

**Example:**

- Input: `nums = [2, 7, 11, 15]`, `target = 9`
- Output: `[0, 1]` (because `nums[0] + nums[1] = 2 + 7 = 9`)

---

## **2. Approaches to Solve the Problem**

### **Brute Force Approach (Naive)**

- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)
- **How it works:**
  - Use two nested loops to check every possible pair.
  - If `nums[i] + nums[j] == target`, return `[i, j]`.

**Disadvantage:**

- Inefficient for large arrays.

### **Optimal Approach (Using Hash Map)**

- **Time Complexity:** O(n) (Single pass)
- **Space Complexity:** O(n) (Storing numbers in a hash map)
- **How it works:**
  - Use a **hash map** (`HashMap<Integer, Integer>`) to store numbers and their indices.
  - For each number `nums[i]`, compute its **complement** (`target - nums[i]`).
  - If the complement exists in the map, return the indices.
  - Otherwise, store `nums[i]` in the map.

**Advantage:**

- Much faster (only one pass needed).

---

## **3. Step-by-Step Explanation of the Optimal Solution**

### **Java Code**

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];

        if (numMap.containsKey(complement)) {
            return new int[]{numMap.get(complement), i};
        }

        numMap.put(nums[i], i);
    }

    return new int[]{}; // No solution (though problem guarantees one)
}
```

### **Step-by-Step Breakdown**

1. **Initialize a `HashMap`** (`numMap`) to store:
   - **Key:** Number from the array (`nums[i]`)
   - **Value:** Index of that number (`i`)

2. **Loop through the array (`nums`)**:
   - For each element `nums[i]`, compute its **complement** (`target - nums[i]`).
   - **Check if the complement exists in `numMap`**:
     - If **YES**, return `[numMap.get(complement), i]` (the stored index and current index).
     - If **NO**, store `nums[i]` and its index (`i`) in `numMap`.

3. **If no solution is found**, return an empty array (though the problem guarantees a solution).

---

## **4. Example Walkthrough**

### **Input:** `nums = [3, 2, 4]`, `target = 6`

1. **i = 0** (`nums[0] = 3`):
   - `complement = 6 - 3 = 3`
   - `numMap` is empty → store `(3, 0)`
2. **i = 1** (`nums[1] = 2`):
   - `complement = 6 - 2 = 4`
   - `numMap` does not contain `4` → store `(2, 1)`
3. **i = 2** (`nums[2] = 4`):
   - `complement = 6 - 4 = 2`
   - `numMap` contains `2` (at index `1`) → **return `[1, 2]`**

**Output:** `[1, 2]` (because `nums[1] + nums[2] = 2 + 4 = 6`)

---

## **5. Edge Cases to Consider**

- **Negative numbers:** `nums = [-1, -2, -3, -4]`, `target = -7` → `[2, 3]`
- **Duplicate numbers:** `nums = [3, 3]`, `target = 6` → `[0, 1]`
- **No solution (but problem says there is one):** `nums = [1, 2, 3]`, `target = 7` → `[]`

---

## **6. Time & Space Complexity**

| Approach              | Time Complexity | Space Complexity |
| --------------------- | --------------- | ---------------- |
| Brute Force           | O(n²)           | O(1)             |
| **Optimal (HashMap)** | **O(n)**        | **O(n)**         |

---
