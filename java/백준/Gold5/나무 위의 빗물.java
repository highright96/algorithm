public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static List<Integer>[] tree;
  private static int N, W;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    N = Integer.parseInt(stk.nextToken());
    W = Integer.parseInt(stk.nextToken());
    tree = new ArrayList[N + 1];
    for (int i = 1; i < N + 1; i++) {
      tree[i] = new ArrayList<>();
    }
    for (int i = 0; i < N - 1; i++) {
      stk = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(stk.nextToken());
      int b = Integer.parseInt(stk.nextToken());
      tree[a].add(b);
      tree[b].add(a);
    }
    int cnt = bfs();
    bw.write(String.format("%.10f", (double) W / cnt));
    bw.flush();
    bw.close();
  }

  public static int bfs() {
    int cnt = 0;
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[N + 1];
    queue.add(1);
    visited[1] = true;
    while (!queue.isEmpty()) {
      boolean flag = false;
      int node = queue.poll();
      for (int i = 0; i < tree[node].size(); i++) {
        int v = tree[node].get(i);
        if (!visited[v]) {
          queue.add(v);
          visited[v] = true;
          flag = true;
        }
      }
      if (!flag) {
        cnt++;
      }
    }
    return cnt;
  }
}