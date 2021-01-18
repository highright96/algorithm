#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int a[101][101];
int c[101][101];
int n = 0;
int check() {
	int cnt = 0, ans = 0;
	for (int i = 0; i < n; i++) {
		cnt++;
		for (int j = 0; j < cnt; j++) {
			if (i == 0 && j == 0) c[i][j] = a[i][j];
			else if (i > 0 && j == 0) c[i][j] = c[i - 1][j] + a[i][j];
			else c[i][j] += max(c[i - 1][j - 1], c[i - 1][j]);
			if (c[i][j] > ans) ans = c[i][j];
		}
	}
	return ans;
}
int main() {
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
	int ans = check();
	cout << ans << endl;
	return 0;
}