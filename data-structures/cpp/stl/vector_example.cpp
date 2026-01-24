#include <iostream>
#include <ostream>
#include <vector>

using namespace std;

int main() {
  vector<int> nums;

  nums.push_back(10);
  nums.push_back(20);
  nums.push_back(30);

  cout << "Size: " << nums.size() << endl;
  cout << "Capacity: " << nums.capacity() << endl;

  for (int i = 0; i < nums.size(); i++) {
    cout << nums[i] << " ";
  }
  cout << endl;
}