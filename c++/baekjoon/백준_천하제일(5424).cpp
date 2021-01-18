#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#define MAX 52
#define INF 10000000
using namespace std;
int main() {
	int n = 0, S = 0, E = 25;
	int c[MAX][MAX] = {}, f[MAX][MAX] = {}, total = 0;
	vector<int> adj[MAX];
	cin >> n;
	for (int i = 0; i < n; i++) {
		
	}
	while (1) {
		int prev[MAX];
		std::fill(prev, prev + MAX, -1);
		std::queue<int> Q;
		Q.push(S);

		while (!Q.empty()) {
			int cur = Q.front();
			Q.pop();

			for (int next : adj[cur]) {
				if (prev[next] == -1 && c[cur][next] - f[cur][next] > 0) {
					Q.push(next);
					prev[next] = cur;
					if (next == E)
						break;
				}
			}
		}
		if (prev[E] == -1) break;
		int flow = INF;

		for (int i = E; i != S; i = prev[i])
			flow = min(flow, c[prev[i]][i] - f[prev[i]][i]);

		for (int i = E; i != S; i = prev[i])
		{

			f[prev[i]][i] += flow;
			f[i][prev[i]] -= flow;
		}
		total += flow;
	}
	cout << total;
	return 0;
}