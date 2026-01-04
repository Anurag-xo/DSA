// A vector is a dynamic sized array that automatically grows when elements are added beyond the current capacity

#include <bits/stdc++.h>
using namespace std;

void explainVector() {
  vector<int> v; // this create an empty container
  v.push_back(1); // will take {1} into it
  v.emplace_back(2); // Similar to push_back when we use this it dynamically increases its size to {1,2} (inserts 2 at the end) // This is also faster than push_back() 
  // we can also take vectors in pairs
  vector<pair<int, int>> vec;
  v.push_back({1, 2});
  v.emplace_back(1,2);
  // just there is a diff in syntax of these two like in pb({1, 2}) we must have curly braces but in eb(1,2) it automatically assumes its a pair

  // this will declare a container of 5 instances of 100 {100, 100, 100, 100, 100}
  vector<int> v(5,100);

  // This will create a container with 5 instances of any garbage value or 0 (dependes on the compiler)
  // {0, 0, 0, 0, 0}
  vector<int> v(5);

  // To copy a container to create another
  // this will only copy the elements and create a whole new diff container at new mem address
  vector<int> v1(5,20); // --> {20, 20, 20, 20, 20}
  vector<int> v2(v1);  //--> {20, 20, 20 ,20, 20}
  
  // Deletion in vectors
  v.erase(v.begin() + 1); // {10, 20, 30, 40} --> {10, 30, 40}
  v.erase(v.begin() + 2, v.begin() + 4); // {10, 20, 12, 23, 35} --> {10, 20, 35} v.erase[start, end]


  //Insertion in vectors
  vector<int> v(2,100); // {100,100}
  v.insert(v.begin(), 300); //{300,100,100}
  v.insert(v.begin() + 1, 2, 10) //{300,10,10,100,100}
  
  cout << v.size(); //2 // this will show hsow many elements are in the vector as of now


  //{10 ,20}
  v.pop_back(); //{10} remove the lasat element.


  // swap
  //v1 --> {10,20};
  //v2 --> {30,40};
  v1.swap(v2); // v1 --> {30,40},v2 --> {10, 20}
  v.clear(); // earases the entire vector.
  cout << v.empty(); // this will return T or F
}
