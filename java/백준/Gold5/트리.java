public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static boolean[] visited;
  private static List<Integer>[] graph;
  private static int M, cnt = 0, root = 0;

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    visited = new boolean[N];
    graph = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      graph[i] = new ArrayList<>();
    }
    StringTokenizer stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int n = Integer.parseInt(stk.nextToken());
      if (n == -1) {
        root = i;
      } else {
        graph[n].add(i);
      }
    }
    stk = new StringTokenizer(br.readLine());
    M = Integer.parseInt(stk.nextToken());
    if (M != root) {
      dfs(root);
    }
    bw.write(cnt + "");
    bw.flush();
    bw.close();
  }

  static void dfs(int idx) {
    if (graph[idx].size() == 0 || (graph[idx].size() == 1 && graph[idx].get(0) == M)) {
      cnt++;
    } else {
      visited[idx] = true;
      for (int i : graph[idx]) {
        if (!visited[i] && i != M) {
          dfs(i);
        }
      }
    }
  }
}