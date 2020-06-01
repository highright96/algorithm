#include <iostream>
using namespace std;

int cache[100] = { 1, 2 };
const int INF = 1000000007;
int main() {
	int T = 0;
	cin >> T;
	while (T--) {
		int n, k = 0;
		cin >> n;
		if (n <= 2) {
			cout << 0 << endl;
			continue;
		}
		for (int i = 2; i < n; i++)
			cache[i] = (cache[i - 1] + cache[i - 2]) % INF;
		if (n % 2 == 0) //Â¦¼ö
			k = (cache[n / 2 - 1] + cache[n / 2 - 2]) % INF;
		else //È¦¼ö
			k = cache[n / 2 - 1];
		cout << (INF + cache[n - 1] - k) % INF << endl;
	}
	return 0;
}