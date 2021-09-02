public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[][] box;
  private static boolean[][] visited;
  private static Queue<Pos> q = new LinkedList<>();
  private static int n, m, max = 0;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    m = Integer.parseInt(stk.nextToken());
    n = Integer.parseInt(stk.nextToken());
    box = new int[n + 2][m + 2];
    visited = new boolean[n + 1][m + 1];
    for (int[] ints : box) {
      Arrays.fill(ints, 3);
    }

    for (int i = 1; i <= n; i++) {
      stk = new StringTokenizer(br.readLine());
      for (int j = 1; j <= m; j++) {
        int t = Integer.parseInt(stk.nextToken());
        box[i][j] = t;
        if (box[i][j] == 1) {
          q.add(new Pos(i, j));
          visited[i][j] = true;
        }
      }
    }
    bfs();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        max = Math.max(max, box[i][j]);
        if (box[i][j] == 0) {
          bw.write("-1");
          bw.flush();
          bw.close();
          return;
        }
      }
    }
    if (max == 1) {
      bw.write("0");
    } else {
      bw.write(String.valueOf(max-1));
    }
    bw.flush();
    bw.close();
  }

  public static void bfs() {
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};
    while (!q.isEmpty()) {
      Pos removed = q.remove();
      for (int i = 0; i < 4; i++) {
        int xx = removed.x + x[i];
        int yy = removed.y + y[i];
        if (box[xx][yy] == 0 && !visited[xx][yy]) {
          visited[xx][yy] = true;
          box[xx][yy] = box[removed.x][removed.y] + 1;
          q.add(new Pos(xx, yy));
        }
      }
    }
  }

  public static class Pos {

    int x;
    int y;

    public Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}