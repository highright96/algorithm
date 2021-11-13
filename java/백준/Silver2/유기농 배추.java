public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] dy = {-1, 1, 0, 0};
  static int[] dx = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringTokenizer stk = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(stk.nextToken());
      int n = Integer.parseInt(stk.nextToken());
      int k = Integer.parseInt(stk.nextToken());
      int[][] arr = new int[n][m];
      boolean[][] visited = new boolean[n][m];
      while (k-- > 0) {
        stk = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(stk.nextToken());
        int j = Integer.parseInt(stk.nextToken());
        arr[j][i] = 1;
      }
      int ans = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (!visited[i][j] && arr[i][j] == 1) {
            dfs(arr, visited, i, j);
            ans++;
          }
        }
      }
      bw.write(ans + "\n");
    }
    bw.flush();
    bw.close();
  }

  public static void dfs(int[][] arr, boolean[][] visited, int row, int col) {
    visited[row][col] = true;
    for (int i = 0; i < 4; i++) {
      int yy = row + dy[i];
      int xx = col + dx[i];
      if (yy >= 0 && yy < arr.length && xx >= 0 && xx < arr[0].length) {
        if (!visited[yy][xx] && arr[yy][xx] == 1) {
          dfs(arr, visited, yy, xx);
        }
      }
    }
  }
}