#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main() {
	int testCase = 0;
	bool check = true;
	vector<int> v; v.push_back(2);
	//int k = 0;
	cin >> testCase;
	vector<vector<int>> ans(testCase);
	for (int i = 3; i <= 1000; i++) {
		for (int j = 2; j < i; j++) {
			if (i % j == 0) {
				check = false;
				break;
			}
		}
		if (check == true) v.push_back(i);
		check = true;
	}
	for (int i = 0; i < testCase; i++) {
		int num = 0;
		cin >> num;
		bool check2 = false;
		for (int a = 0; a < v.size(); a++) {
			for (int b = 0; b < v.size(); b++) {
				for (int c = 0; c < v.size(); c++) {
					if (v[a] + v[b] + v[c] == num) {
						ans[i].push_back(v[a]); ans[i].push_back(v[b]); ans[i].push_back(v[c]);
						check2 = true;
						break;
					}
				}
				if (check2 == true) break;
			}
			if (check2 == true) break;
		}
	}
	for (int i = 0; i < testCase; i++) sort(ans[i].begin(), ans[i].end());
	for (int i = 0; i < testCase; i++) {
		if (ans[i].size() < 3) cout << "0";
		else {
			for (int j = 0; j < ans[i].size(); j++) cout << ans[i][j] << " ";
		}
		cout << endl;
	}
	return 0;
}