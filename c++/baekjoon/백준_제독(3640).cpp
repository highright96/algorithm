#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;

#define MAX 2005
#define VERTEX 1000
int S = MAX - 2, E = MAX - 1;

int main() {
	int n, m;
	while (scanf("%d %d", &n, &m) != EOF)
	{
		int c[MAX][MAX] = {}, f[MAX][MAX] = {}, d[MAX][MAX] = {}, total = 0;
		vector<int> adj[MAX];
		adj[S].push_back(1), adj[1].push_back(S), c[S][1] = 2;
		adj[E].push_back(VERTEX + n), adj[VERTEX + n].push_back(E), c[VERTEX + n][E] = 2;
		for (int i = 1; i <= n; i++) {
			adj[i].push_back(VERTEX + i), adj[VERTEX + i].push_back(i), c[i][VERTEX + i] = 1;
			if (i == 1 || i == n) c[i][VERTEX + i] = 2;
		}
		for (int i = 0; i < m; i++)
		{
			int from, to, val;
			scanf("%d %d %d", &from, &to, &val);
			adj[VERTEX + from].push_back(to), adj[to].push_back(VERTEX + from);
			c[VERTEX + from][to] = 1;
			d[VERTEX + from][to] = val;
			d[to][VERTEX + from] = -val;

		}

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
		}
		cout << total;
	}
	return 0;
}