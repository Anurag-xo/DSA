// An iterator is an object that behaves like a pointer to traverse and access elements of a container.
// - They allow container traversal without exposing internal structure.
// - Support container-independent algorithm like sort(), conunt() and find().


#include <bits/stdc++.h> 
using namespace std;

int explainIterator() {
  // sytax
  container_type :: iterator it;
  // OR
  auto it = container.begin();

  // v.begin() will reutrn the memeory address
  vector<int> :: iterator it = v.begin();
  it++;
  cout << *(it) << " ";
  // * is used to point it to the object at that memory location.
  it = it + 2; // this will print after two pointers.
  cout << *(it)<< " ";


  // This will point to the element after the last element which will contain a memory location.
  // so to accces the last element we have to use [it--]
  vector<int> :: iterator it = v.end();

  cout << v[0] << endl; // To print the element at index 0
  cout <<v.back() << " "; // This will return the last element

  // to print the entire vector
  for(vector<int> :: iterator it = v.begin(); it != v.end(); it++){
    cout << *(it) << " ";
  }

  // using (auto) much easier  way
  for(auto it = v.begin(); it != v.end(); it++) {
    cout << *(it) << " ";
  }

  //using for each loop (best)
  for(auto it : v) {
    cout << it << " ";
  }
}
