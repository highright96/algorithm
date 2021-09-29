public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[][] board;
  private static int[] dy = {0, -1, 0, 1};
  private static int[] dx = {-1, 0, 1, 0};
  private static int N, M, cheese = 0;
  
  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    N = Integer.parseInt(stk.nextToken());
    M = Integer.parseInt(stk.nextToken());
    board = new int[N][M];
    for (int i = 0; i < N; i++) {
      stk = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int v = Integer.parseInt(stk.nextToken());
        if (v == 1) {
          cheese++;
        }
        board[i][j] = v;
      }
    }
    int time = 0;
    int prevCheese = 0;
    while(cheese != 0){
      time++;
      prevCheese = cheese;
      melt();
    }
    bw.write(time + "\n");
    bw.write(prevCheese + "\n");
    bw.flush();
    bw.close();
  }

  public static void melt() {
    Queue<Pos> q = new LinkedList<>();
    boolean[][] visited = new boolean[N][M];
    q.add(new Pos(0, 0));
    visited[0][0] = true;
    while (!q.isEmpty()) {
      Pos p = q.poll();
      for (int k = 0; k < 4; k++) {
        int y = p.y + dy[k];
        int x = p.x + dx[k];
        if (y >= 0 && x >= 0 && y < N && x < M) {
          if (!visited[y][x] && board[y][x] == 0) {
            q.add(new Pos(y, x));
          } else if (board[y][x] == 1) {
            cheese--;
            board[y][x] = 0;
          }
          visited[y][x] = true;
        }
      }
    }
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