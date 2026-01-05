#include <bits/stdc++.h>
using namespace std;

int largetElement(vector<int> &arr, int n) {
  int largest = arr[0];
  for(int i = 0; i < n; i++) {
    if (arr[i] > largest) {
      larget = arr[i];
    }
  }
  return largest;
}
