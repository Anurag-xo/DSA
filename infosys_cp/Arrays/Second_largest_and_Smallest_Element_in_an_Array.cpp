#include <bits/stdc++.h>
using namespace std;
// to find the secondlargest
int secondLargest(vector<int> &arr, int n) {
  int largest = arr[0];
  int slargest = -1;

  for(int i = 1; i < n; i++) {
    if(arr[i] > largest) {
      slargest = largest;
      largest = arr[i];
    }
    else if (arr[i] < largest && arr[i] > slargest) {
      slargest = arr[i];
    }
  }
  return slargest;
}
// to find the second smallest
int secondSmallest(vector<int> &arr, int n) {
  int smallest =  a[0];
  int ssmallest = INT_MAX;

  for(int i = 1; i < n; i++) {
    if (arr[i] < smallest) {
      ssmallest = smallest;
      smallest = arr[i];
    }
    else if (arr[i] != smallest && arr[i] < ssmallest) {
      ssmallest = arr[i];
    }
  }
  return ssmallest;
}

// main function 
vector<int> getSecondOrderElements(int n, vector<int> a) {
  int slargest = secondLargest(arr, n);
  int ssmallest = secondSmallest(arr, n);
  return slargest, ssmallest;
}
