# Order Agnostic Binary Search in Java

This document explains the `OrderAgnosticBS` Java class, which implements **Order Agnostic Binary Search**. This allows you to perform binary search on arrays sorted in **either ascending or descending order**—a very useful technique when the sort order isn't known in advance.

---

## 📋 Problem Statement

Given a **sorted array** (the order can be ascending or descending) and a `target` value, return the index of `target` in the array using binary search. If the element does not exist, return `-1`.

---

## 🧑‍💻 Code Explained

```java
public class OrderAgnosticBS {

  public static void main(String[] args) {
    // int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
    int[] arr = {99, 80, 75, 22, 11, 10, 5, 2, -3};
    int target = 22;
    int ans = orderAgnosticBS(arr, target);
    System.out.println(ans);
  }

  static int orderAgnosticBS(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    // find if the array is sorted in ascending or descending
    boolean isAsc = arr[start]  arr[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      }
    }
    return -1;
  }
}
```

---

## 🧩 How the Code Works—Detailed Steps

### 1. **Array and Target Initialization**

You can switch between two sample arrays:

- Ascending: `{ -18, -12, -4, 0, 2, 3, ... }`
- Descending: `{ 99, 80, 75, 22, 11, ... }`

Here, the code uses the descending array and searches for 22.

---

### 2. **Determine Sort Order**

```java
boolean isAsc = arr[start]  arr[mid]) {
            end = mid - 1;     // Move left (since values decrease)
        } else {
            start = mid + 1;   // Move right
        }
    }
}
return -1; // Not found
```

**Key Insight:**

- For _ascending_, move left if target is less than mid; move right if greater.
- For _descending_, move right if target is less; move left if greater.

---

## 💡 Why Use Order Agnostic Binary Search?

- The sort order is not always known (e.g., user input, unpredictable sources).
- One function handles both ascending and descending arrays.
- **Practical for interviews and coding challenges.**

---

## 🖨 Output Example

For array `{99, 80, 75, 22, 11, 10, 5, 2, -3}` and target `22`, the output is:

```
3
```

This means `22` is at index 3 in the array.

---

## 🚧 Common Mistakes

- Forgetting to adjust the comparison logic for descending arrays.
- Not handling cases where the array has only one element (`start == end`).
- Not verifying the array is actually sorted.

---

## 📝 Summary Table

| Step       | Ascending array   | Descending array  |
| ---------- | ----------------- | ----------------- |
| Move Left  | target arr[mid]   |
| Move Right | target > arr[mid] | target < arr[mid] |

---

## ⚙️ Complexity

- **Time Complexity:** O(log n)
- **Space Complexity:** O(1)

---

## 🔗 Further Reading

- [GeeksforGeeks: Order Agnostic Binary Search](https://www.geeksforgeeks.org/order-agnostic-binary-search/)
- [Kunal Kushwaha: Order Agnostic Binary Search (YouTube)](https://www.youtube.com/watch?v=6zhGS79oQ4k)

---

**Order-agnostic binary search is a powerful generalization of binary search, making your code ready for any sorted array!**

```

```
