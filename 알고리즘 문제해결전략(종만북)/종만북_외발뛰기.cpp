#include <iostream>
using namespace std;

int arr[101][101];
int cache[101][101];
int n = 0;

//0 false, 1 true
int check(int a, int b) {
	if (a >= n || b >= n) return 0;
	if (a == n - 1 && b == n - 1) return 1;
	if (cache[a][b] != -1) return cache[a][b];
	cache[a][b] = (check(a, b + arr[a][b]) || check(a + arr[a][b], b));
	return cache[a][b];
}
int main() {
	int ans = -1;
	cin >> n;
	memset(cache, -1, sizeof(cache));
	memset(arr, -1, sizeof(arr));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cin >> arr[i][j];
	}
	ans = check(0, 0);
	if (ans == 0) cout << "no" << endl;
	else cout << "yes" << endl;
	return 0;
}