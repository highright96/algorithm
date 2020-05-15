#include <Iostream>
#include <algorithm>
#include <vector>
using namespace std;
void solve() {

}
int main() {
	int N = 0;
	cin >> N;
	vector<vector<int>>v(N, vector<int>(N, 0));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> v[i][j];
		}
	}
	return 0;
}