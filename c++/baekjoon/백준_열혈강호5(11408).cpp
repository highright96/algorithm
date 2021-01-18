#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;

#define MAX 805
#define WORK 400
int S = MAX - 2, E = MAX - 1;

int main() {
	int c[MAX][MAX] = {}, f[MAX][MAX] = {}, d[MAX][MAX] = {}, total = 0;
	vector<int> adj[MAX];
	int n, m;
	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		adj[S].push_back(i), adj[i].push_back(S), c[S][i] = 1;
	}
	for (int i = 1; i <= m; i++) {
		adj[E].push_back(WORK + i), adj[WORK + i].push_back(E), c[WORK + i][E] = 1;
	}
	for (int i = 1; i <= n; i++) {
		int k;
		cin >> k;
		int u, v;
		for (int j = 1; j <= k; j++) {
			cin >> u >> v, adj[WORK + u].push_back(i), adj[i].push_back(WORK + u);
			d[WORK + u][i] = -v, d[i][WORK + u] = v, c[i][WORK + u] = 1;
		}
	}
	int cnt = 0;
	while (1) {
		int prev[MAX], dist[MAX];
		bool inQ[MAX] = {};
		std::fill(prev, prev + MAX, -1);
		std::fill(dist, dist + MAX, 1e9);
		std::queue<int> Q;
		Q.push(S);
		inQ[S] = true;
		dist[S] = 0;

		while (!Q.empty()) {
			int cur = Q.front();
			Q.pop();
			inQ[cur] = false;

			for (int next : adj[cur]) {
				if (c[cur][next] - f[cur][next] > 0 && dist[next] > dist[cur] + d[cur][next]) {
					dist[next] = dist[cur] + d[cur][next];
					prev[next] = cur;
					if (!inQ[next]) inQ[next] = true, Q.push(next);
				}
			}
		}
		if (prev[E] == -1) break;
		int flow = 1e9;

		for (int i = E; i != S; i = prev[i])
			flow = min(flow, c[prev[i]][i] - f[prev[i]][i]);

		for (int i = E; i != S; i = prev[i])
		{
			total += flow * d[prev[i]][i];
			f[prev[i]][i] += flow;
			f[i][prev[i]] -= flow;
		}
		cnt += flow;
	}
	cout << cnt << endl << total;
	return 0;
}