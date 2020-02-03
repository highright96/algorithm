#include <iostream>
#include <vector>
using namespace std;
int main() {
	int testCase = 0;
	cin >> testCase;
	vector<int> k(testCase); //정답을 넣을 배열
	for (int i = 0; i < testCase; i++) {
		int n = 0, m = 0;
		int x = 0, y = 0;
		int cnt = 0, digit = 0, num = 0;
		cin >> n >> m;
		for (int i = 0; i < m; i++) {
			int a; cin >> a;
			x = x * 10 + a;
		}
		for (int i = 0; i < m; i++) {
			int a; cin >> a;
			y = y * 10 + a;
		}
		vector<int> w(n);
		for (int i = 0; i < n; i++) {
			cin >> w[i];
		}
		int j = 0;
		for (int i = 0; i < n; i++) {
			digit = 0;
			num = 0;
			j = 0;
			while (j < m) {
				num = num * 10 + w[(j + i) % n];
				j++;
				digit++;
			}
			if (num >= x && num <= y) cnt++;
		}
		//cout << cnt << " ";
		k.push_back(cnt);
	}
	for (int i = 0; i < k.size(); i++) cout << k[i] << endl;
	return 0;
}