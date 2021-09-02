public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[][][] box;
  private static boolean[][][] visited;
  private static Queue<Pos> q = new LinkedList<>();
  private static int n, m, h, max = 0;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    m = Integer.parseInt(stk.nextToken());
    n = Integer.parseInt(stk.nextToken());
    h = Integer.parseInt(stk.nextToken());
    box = new int[h][n][m];
    visited = new boolean[h][n][m];

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        stk = new StringTokenizer(br.readLine());
        for (int k = 0; k < m; k++) {
          int t = Integer.parseInt(stk.nextToken());
          box[i][j][k] = t;
          if (t == 1) {
            q.add(new Pos(i, j, k));
            visited[i][j][k] = true;
          }
        }
      }
    }
    bfs();
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          max = Math.max(max, box[i][j][k]);
          if (box[i][j][k] == 0) {
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
          }
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
    int[] dh = {0, 0, -1, 1, 0, 0};
    int[] dn = {0, 0, 0, 0, -1, 1};
    int[] dm = {-1, 1, 0, 0, 0, 0};
    while (!q.isEmpty()) {
      Pos removed = q.remove();
      for (int i = 0; i < 6; i++) {
        int hh = removed.h + dh[i];
        int nn = removed.n + dn[i];
        int mm = removed.m + dm[i];
        if (hh >= 0 && nn >= 0 && mm >= 0 && hh < h && nn < n && mm < m) {
          if (box[hh][nn][mm] == 0 && !visited[hh][nn][mm]) {
            visited[hh][nn][mm] = true;
            box[hh][nn][mm] = box[removed.h][removed.n][removed.m] + 1;
            q.add(new Pos(hh, nn, mm));
          }
        }
      }
    }
  }

  public static class Pos {

    int h;
    int n;
    int m;

    public Pos(int h, int n, int m) {
      this.h = h;
      this.n = n;
      this.m = m;
    }
  }
}