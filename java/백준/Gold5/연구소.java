public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[][] map;
  private static List<Pos> list = new ArrayList<>();
  private static int N, M, ans = Integer.MIN_VALUE;
  private static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우
  private static int[] dx = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    N = Integer.parseInt(stk.nextToken());
    M = Integer.parseInt(stk.nextToken());
    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      stk = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(stk.nextToken());
        if (map[i][j] == 2) {
          list.add(new Pos(i, j));
        }
      }
    }
    wall(0);
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }

  static void wall(int cnt) {
    if (cnt == 3) {
      bfs();
      return;
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          map[i][j] = 1;
          wall(cnt + 1);
          map[i][j] = 0;
        }
      }
    }
  }

  static void bfs() {
    //배열 복사
    int[][] copy = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        copy[i][j] = map[i][j];
      }
    }

    Queue<Pos> q = new LinkedList<>(list);

    while (!q.isEmpty()) {
      Pos p = q.poll();
      for (int i = 0; i < 4; i++) {
        int n = p.n + dy[i];
        int m = p.m + dx[i];
        if (n >= 0 && m >= 0 && n < N && m < M) {
          if (copy[n][m] == 0) {
            copy[n][m] = 2;
            q.add(new Pos(n, m));
          }
        }
      }
    }
    //안전구역 확인
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (copy[i][j] == 0) {
          cnt++;
        }
      }
    }
    ans = Math.max(ans, cnt);
  }

  static class Pos {

    int n;
    int m;

    public Pos(int n, int m) {
      this.n = n;
      this.m = m;
    }
  }
}