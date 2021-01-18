#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> v;
int N = 0, M = 0, ans = 0;
void solve(int mid, int min, int max) {
	int ra = mid, cnt = 1;
	for (int i = 0; i < N; i++) {
		if (v[i] > mid) {
			min = mid + 1;
			mid = (min + max) / 2;
			if (max >= min)
				solve(mid, min, max);
			return;
		}
		if (ra >= v[i]) {
			ra -= v[i];
		}
		else {
			ra = mid;
			ra -= v[i];
			cnt++;
		}
	}
	if (cnt <= M) {
		ans = mid;
		max = mid - 1;
		mid = (min + max) / 2;
		if (max >= min) 
			solve(mid, min, max);
	}
	else {
		min = mid + 1;
		mid = (min + max) / 2;
		if (max >= min)
			solve(mid, min, max);
	}
	return;
}
int main() {
	int sum = 0, mid = 0, min = 0;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		int a = 0;
		cin >> a;
		sum += a;
		v.push_back(a);
	}
	mid = sum / 2;
	solve(mid, 0, sum);
	cout << ans;
	return 0;
}