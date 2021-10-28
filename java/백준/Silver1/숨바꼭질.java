public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int[] dist;
  static int total = 0, max = Integer.MIN_VALUE, ans = 0;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stk.nextToken());
    int m = Integer.parseInt(stk.nextToken());
    graph = new ArrayList[n + 1];
    for (int i = 1; i < n + 1; i++) {
      graph[i] = new ArrayList<>();
    }
    visited = new boolean[n + 1];
    dist = new int[n + 1];

    for (int i = 0; i < m; i++) {
      stk = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(stk.nextToken());
      int b = Integer.parseInt(stk.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }
    bfs(1);
    for (int i = dist.length - 1; i >= 0; i--) {
      if (dist[i] == max) {
        ans = i;
        total += 1;
      }
    }
    bw.write(ans + " " + max + " " + total);
    bw.flush();
    bw.close();
  }

  static void bfs(int idx) {
    Queue<Integer> queue = new LinkedList<>();
    dist[1] = 0;
    visited[idx] = true;
    queue.add(idx);
    while (!queue.isEmpty()) {
      int p = queue.poll();
      for (int n : graph[p]) {
        if (!visited[n]) {
          queue.add(n);
          visited[n] = true;
          dist[n] = dist[p] + 1;
          max = Math.max(dist[n], max);
        }
      }
    }
  }
}