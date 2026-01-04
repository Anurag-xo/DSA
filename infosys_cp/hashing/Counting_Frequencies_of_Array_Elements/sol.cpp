#includ <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<vector<int>> countFrequencies(vector<int>& nums) {
    unorderd_map<int, int> map;
    vector<vector<int>> result;

    //count frequencies
    for(int num : nums) {
      map[num]++;
    }

    // Build result
    for(auto& pair : map) {
      result.push_back({pair.first, pair.second});
    }
    return result;
  }
};
