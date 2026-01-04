// pair is a simple container that holds two values together, These two values can be of different types, and they are stored as a single unit.

void explainPair() {
  pair<int, int> p = {1, 3};
  cout << p.first << " " << p.second;
  
  // to store more than two values
  // also known as nested pair
  pair<int,<pair<int, int>> p = {1,{3,4}};
  cout << p.first << " " << p.second.second << " " << p.second.first;

  pair<int, int> arr[] = {{1,2}, {2,5}, {5,1}};
  cout << arr[1].second; // this will print {2,5}
} 
