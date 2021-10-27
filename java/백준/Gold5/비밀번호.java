public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int ans = 0;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stk.nextToken());
    int m = Integer.parseInt(stk.nextToken());
    visited = new boolean[10];
    if (m != 0) {
      stk = new StringTokenizer(br.readLine());
      for (int i = 0; i < m; i++) {
        visited[Integer.parseInt(stk.nextToken())] = true;
      }
    }
    back(0, n, m, 0);
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }

  static void back(int cnt, int n, int m, int use) {
    if (cnt == n) {
      if (use == m) {
        ans += 1;
      }
      return;
    }
    for (int i = 0; i <= 9; i++) {
      if (visited[i]) {
        visited[i] = false;
        back(cnt + 1, n, m, use + 1);
        visited[i] = true;
      } else {
        back(cnt + 1, n, m, use);
      }
    }
  }
}