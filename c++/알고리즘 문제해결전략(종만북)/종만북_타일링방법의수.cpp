#include <iostream>
using namespace std;
#define MOD 1000000007;
int cache[100] = { 1, 2 };
int main() {
	int n = 0;
	cin >> n;
	for (int i = 2; i < n; i++)
		cache[i] = (cache[i - 1] + cache[i - 2])%MOD;
	cout << cache[n - 1] << endl;
	return 0;
}