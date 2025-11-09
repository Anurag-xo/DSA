import java.util.HashSet;

class Solution {
  public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
    int sumA = 0, sumB = 0;

    for (int a : aliceSizes) sumA += a;
    for (int b : bobSizes) sumB += b;

    int delta = (sumB - sumA) / 2;

    Set<Integer> bobSet = new HashSet<>(bobSizes.length);
    for (int b : bobSizes) bobSet.add(b);

    for (int a : aliceSizes) {
      int needed = a + delta;
      if (bobset.contains(needed)) {
        return new int[] {a, needed};
      }
    }
    return new int[0];
  }
}
