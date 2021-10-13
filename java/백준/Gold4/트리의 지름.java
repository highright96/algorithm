public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static List<List<Node>> graph;
  static boolean[] visited;
  static int maxV = 0, maxI = 0;

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 1; i < N; i++) {
      StringTokenizer stk = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(stk.nextToken());
      int n = Integer.parseInt(stk.nextToken());
      int v = Integer.parseInt(stk.nextToken());
      graph.get(p).add(new Node(n, v));
      graph.get(n).add(new Node(p, v));
    }
    visited = new boolean[N+1];
    dfs(1, 0);
    maxV = 0;
    visited = new boolean[N+1];
    dfs(maxI, 0);
    bw.write(maxV + "");
    bw.flush();
    bw.close();
  }

  static void dfs(int idx, int v) {
    if (v > maxV) {
      maxV = v;
      maxI = idx;
    }
    visited[idx] = true;
    for (Node node : graph.get(idx)) {
      if (!visited[node.n]) {
        dfs(node.n, v + node.v);
      }
    }
  }

  static class Node {

    int n;
    int v;

    public Node(int n, int v) {
      this.n = n;
      this.v = v;
    }
  }
}