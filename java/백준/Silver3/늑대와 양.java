public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static boolean[][] visited;
  static char[][] arr;
  static int n, m;
  static boolean isReturn = false;
  static int[] dy = {-1, 1, 0, 0};
  static int[] dx = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(stk.nextToken());
    m = Integer.parseInt(stk.nextToken());
    visited = new boolean[n][m];
    arr = new char[n][m];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && arr[i][j] == 'W') {
          dfs(i, j);
        }
      }
    }

    if (isReturn) {
      bw.write("0");
    } else {
      bw.write("1\n");
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          bw.write(arr[i][j]);
        }
        bw.newLine();
      }
    }
    bw.flush();
    bw.close();
  }

  public static void dfs(int row, int col) {
    visited[row][col] = true;
    for (int i = 0; i < 4; i++) {
      int yy = row + dy[i];
      int xx = col + dx[i];
      if (yy >= 0 && yy < n && xx >= 0 && xx < m) {
        if (isReturn) {
          return;
        }
        if (!visited[yy][xx] && arr[yy][xx] == '.') {
          dfs(yy, xx);
        } else if (arr[yy][xx] == 'S' && arr[row][col] == 'W') {
          isReturn = true;
        } else if (arr[yy][xx] == 'S' && arr[row][col] == '.') {
          arr[row][col] = 'D';
          return;
        }
      }
    }
  }
}