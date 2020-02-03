#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#define MAX 305
#define INF 1000000000
using namespace std;

struct h {
	int from;
	int to;
};
int main() {
	int testcase = 0;
	cin >> testcase;
	for (int i = 0; i < testcase; i++){
		int c[MAX][MAX] = {}, f[MAX][MAX] = {}, total = 0;
		int n = 0, m = 0;
		cin >> n >> m;
		vector<int> adj[MAX]; vector<h> EDGE;
		for (int j = 1; j <= m; j++) {
			int from, to, val;
			cin >> from >> to >> val;
			adj[from].push_back(to);
			adj[to].push_back(from);
			c[from][to] += val;
			struct h h;
			h.from = from;
			h.to = to;
			EDGE.push_back(h);
		}
		int S = 1, E = n;
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
		int ans = 0;
		for (int i = 0; i < EDGE.size(); i++) {
			S = EDGE[i].from;
			E = EDGE[i].to;
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
			if (prev[E] == -1) ans++;
		}
		cout << ans << endl;
	}
	return 0;
}
