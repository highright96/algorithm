#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int TestCase = 0;
	vector<int> ans;
	cin >> TestCase;
	for (int i = 0; i < TestCase; i++)
	{
		int n = 0;
		cin >> n;
		int min = 0;
		vector<int> v(n);
		for (int i = 0; i < n; i++) cin >> v[i];
		sort(v.begin(), v.end());
		for (int i = 0; i < n - 2; i++) {
			int a = 0, b = 0;
			a = v[i]; b = v[i + 2];
			int c = b - a;
			if (min < c) min = c;
		}
		ans.push_back(min);
	}
	for (int i = 0; i < ans.size(); i++) cout << ans[i] << endl;
	return 0;
}