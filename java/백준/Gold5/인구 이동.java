public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우
  private static int[] dx = {0, 0, -1, 1};
  private static int n, l, r;
  private static int[][] arr;
  private static List<Pos> list;
  private static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    int ans = 0;
    StringTokenizer stk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(stk.nextToken());
    l = Integer.parseInt(stk.nextToken());
    r = Integer.parseInt(stk.nextToken());
    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      stk = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(stk.nextToken());
      }
    }
    while (true) {
      boolean isChk = false;
      visited = new boolean[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (!visited[i][j]) {
            if (bfs(new Pos(i, j))) {
              isChk = true;
            }
          }
        }
      }
      if (!isChk) {
        break;
      }
      ans++;
    }
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }

  public static boolean bfs(Pos pos) throws IOException {
    Queue<Pos> q = new LinkedList<>();
    list = new ArrayList<>();
    list.add(pos);
    q.add(pos);
    int sum = arr[pos.y][pos.x];
    visited[pos.y][pos.x] = true;
    while (!q.isEmpty()) {
      Pos p = q.poll();
      for (int i = 0; i < 4; i++) {
        int y = dy[i] + p.y;
        int x = dx[i] + p.x;
        if (x >= 0 && y >= 0 && x < n && y < n) {
          int diff = Math.abs(arr[p.y][p.x] - arr[y][x]);
          if (!visited[y][x] && diff >= l && diff <= r) {
            Pos np = new Pos(y, x);
            list.add(np);
            q.add(np);
            visited[y][x] = true;
            sum += arr[y][x];
          }
        }
      }
    }
    if (list.size() > 1) {
      int r = sum / list.size();
      for (Pos p : list) {
        arr[p.y][p.x] = r;
      }
      return true;
    }
    return false;
  }

  static class Pos {

    int y;
    int x;

    public Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}