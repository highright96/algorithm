#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int a[101][101];
pair<int,int> c[101][101]; //first 최대값, second 경로 수
vector<int> f;
int n = 0;
int check() {
	int cnt = 0, ans = 0, z = 0;
	for (int i = 0; i < n; i++) {
		cnt++;
		for (int j = 0; j < cnt; j++) {
			if (i == 0 && j == 0) {
				c[i][j].first = a[i][j];
				c[i][j].second = 1;
			}
			else if (i > 0 && j == 0) {
				c[i][j].first = c[i - 1][j].first + a[i][j];
				c[i][j].second = 1;
			}
			else {
				if (c[i - 1][j - 1].first == c[i - 1][j].first) {
					c[i][j].first = c[i - 1][j].first + a[i][j];
					c[i][j].second = c[i - 1][j - 1].second + c[i - 1][j].second;
				}
				else if (c[i - 1][j - 1].first > c[i - 1][j].first) {
					c[i][j].first = c[i - 1][j - 1].first + a[i][j];
					c[i][j].second = c[i - 1][j - 1].second;
				}
				else {
					c[i][j].first = c[i - 1][j].first + a[i][j];
					c[i][j].second = c[i - 1][j].second;
				}
			}
			if (c[i][j].first > ans) ans = c[i][j].first;
		}
		for (int k = 0; k < n; k++)
			if (c[n - 1][k].first == ans) z += c[n - 1][k].second;
	}
	return z;
}

int main() {
	int T = 0;
	cin >> T;
	while (T--) {
		int cnt = 0;
		cin >> n;
		memset(a, -1, sizeof(a));
		memset(c, -1, sizeof(c));
		for (int i = 0; i < n; i++) {
			cnt++;
			for (int j = 0; j < cnt; j++) {
				cin >> a[i][j];
			}
		}
		int k = check();
		f.push_back(k);
	}
	for (int m = 0; m < f.size(); m++)
		cout << f[m] << endl;
	return 0;
}