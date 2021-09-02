public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static char[][] arr;
  private static int[][] time;
  private static Queue<Bomb> q = new LinkedList<>();
  private static int r, c, n;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    r = Integer.parseInt(stk.nextToken());
    c = Integer.parseInt(stk.nextToken());
    n = Integer.parseInt(stk.nextToken());
    arr = new char[r][c];
    time = new int[r][c];
    for (int i = 0; i < r; i++) {
      String s = br.readLine();
      for (int j = 0; j < c; j++) {
        arr[i][j] = s.charAt(j);
        if (s.charAt(j) == 'O') {
          time[i][j] = 0;
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      //시간 추가
      for (int j = 0; j < r; j++) {
        for (int k = 0; k < c; k++) {
          if (arr[j][k] == 'O') {
            time[j][k] += 1;
            if (time[j][k] == 3) {
              time[j][k] = 0;
              q.add(new Bomb(j, k));
            }
          }
        }
      }

      if (i % 2 == 0) {
        //빈 곳에 폭탄 설치
        for (int j = 0; j < r; j++) {
          for (int k = 0; k < c; k++) {
            if (arr[j][k] == '.') {
              arr[j][k] = 'O';
              time[j][k] = 0;
            }
          }
        }
      }
      //폭탄 터트리기
      bfs();
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        bw.write(arr[i][j]);
      }
      bw.write("\n");
    }
    bw.flush();
    bw.close();
  }

  public static void bfs() {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    while (!q.isEmpty()) {
      Bomb bomb = q.poll();
      arr[bomb.r][bomb.c] = '.';
      for (int i = 0; i < 4; i++) {
        int rr = bomb.r + dr[i];
        int cc = bomb.c + dc[i];
        if (rr >= 0 && cc >= 0 && rr < r && cc < c) {
          arr[rr][cc] = '.';
          time[rr][cc] = 0;
        }
      }
    }
  }

  public static class Bomb {

    int r;
    int c;

    public Bomb(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}