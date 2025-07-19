# Binary Search Algorithm: Detailed Notes

Binary search is one of the most fundamental and efficient search algorithms used in computer science. It enables you to locate an element within a **sorted array** in logarithmic time, O(log n). Below you'll find all the important details, best practices, sample code, and key considerations for binary search.

---

## 📚 What is Binary Search?

Binary search is an algorithm that allows you to rapidly find a target value in a sorted data structure (commonly arrays). Instead of checking every element one by one (like linear search), it divides the search space in half after each comparison, quickly narrowing down the possibilities.

---

## 📝 Preconditions

- **Array must be sorted** (ascending or descending; algorithm should match the order).
- **Random access is available**, typically applicable to arrays or similar data structures.
- **Not ideal for linked lists**, as access is sequential, not random.

---

## ⚙️ How Does Binary Search Work?

1. **Set boundaries:** Initialize two pointers, `start` and `end`, representing the current search range.
2. **Find the middle:** Compute the midpoint. `mid = start + (end - start) / 2` (safer than `(start + end)/2` for large indices).
3. **Comparison:**
   - If `arr[mid]` == target, return `mid` (target found).
   - If `arr[mid]` target, adjust `end = mid - 1` (search left half).
4. **Continue:** Repeat steps 2–3 until `start > end`.
5. **Return:** If the target is not found, return `-1` or another indicator.

---

## 🔍 Example: Iterative Binary Search in Java

```java
public class BinarySearch {
public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int target = 5;
        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + result);
        }
    }

}
```

---

## 🧮 Time & Space Complexity

- **Time Complexity:** O(log n), where _n_ is the number of elements.
- **Space Complexity:** O(1) for iterative, O(log n) for recursive implementations due to the call stack.

---

## ✅ Advantages

- Much faster than linear search for large sorted lists.
- Easy to implement iteratively and recursively.
- Reduces number of comparisons significantly.

---

## ⚠️ Limitations & Common Mistakes

- **Works only on sorted arrays**: Applying it on unsorted data yields incorrect results.
- **Index calculation pitfalls:** Always use `mid = start + (end - start) / 2` to avoid overflow.
- **Off-by-one errors:** Be careful with loop conditions (`<=` vs `<`).
- **Not suitable for linked lists:** Due to lack of random access.
- **Duplicates:** Standard version returns any occurrence. For first/last occurrence (range queries), modify the algorithm.

---

## 🧠 Binary Search Variants

- **Recursive Binary Search:** Implemented using function calls.
- **Finding First or Last Occurrence:** Useful for repeated elements.
- **Finding Insert Position (Lower & Upper Bound):** Find where the target should be inserted to maintain order.

---

## 💡 Tips & Best Practices

- Always check if the array is sorted.
- Use variables with clear and simple names: `start`, `end`, `mid`.
- Defensive programming: Handle edge cases (empty array, single element).
- When working with large arrays, integer overflow can happen in `mid = (start + end)/2`, use `mid = start + (end - start)/2` instead.
- Consider if your search range should be inclusive (`<=`) or exclusive (`<`) at each end.

---

## 📖 Further Reading

- [GeeksforGeeks: Binary Search](https://www.geeksforgeeks.org/binary-search/)
- [Wikipedia: Binary Search Algorithm](https://en.wikipedia.org/wiki/Binary_search_algorithm)
- [LeetCode: Binary Search Problems](https://leetcode.com/tag/binary-search/)

---

**Remember:**  
Binary search is a powerful tool. Mastering it helps you excel at many coding interviews, algorithm questions, and efficient programming in general!
