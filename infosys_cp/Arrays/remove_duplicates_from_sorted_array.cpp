// Remove duplicates from a sorted array (modify and return no. of unique elements)

#include <bits/stdc++.h>
using namespace std;

int removeDuplicates(vector<int> &arr, int n) {
  int i = 0; // take the first element or i must say index
  for(Int j = 1; j < n ; j++){
    if (arr[i] != arr[j]){
      arr[i+1] = arr[j];
      i++;
    }
  }
  return i + 1;
}
