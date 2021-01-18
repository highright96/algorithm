#include <iostream>
#include <algorithm>
using namespace std;
int arr[101];
int cache[101];
int n = 0, ans = 0;
void lis() {
	int m = 0;
	for (int i = 0; i < n; i++) {
		if (i == 0) cache[i] = 1;
		for (int j = 0; j < i; j++)
			if (arr[j] < arr[i]) {
				m = max(cache[j], m);
				cache[i] = m + 1;
			}
			else cache[i] = 1;
		ans = max(ans, cache[i]);
	}
	cout << ans << endl;
}
int main() {
	memset(arr, -1, sizeof(arr));
	memset(cache, -1, sizeof(cache));
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	lis();
	//for (int a = 0; a < n; a++) cout << cache[a] << " ";
	return 0;
}