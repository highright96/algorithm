public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[][] arr;
  private static boolean[][] isOut;
  private static int w, h, total = 0;
  private static int[][] dy = {{-1, 0, 1, 1, 0, -1}, {-1, 0, 1, 1, 0, -1}};  // 세로
  private static int[][] dx = {{0, 1, 0, -1, -1, -1}, {1, 1, 1, 0, -1, 0}};  // 가로

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    w = Integer.parseInt(stk.nextToken());
    h = Integer.parseInt(stk.nextToken());
    arr = new int[h + 2][w + 2];
    isOut = new boolean[h + 2][w + 2];
    for (int i = 1; i <= h; i++) {
      stk = new StringTokenizer(br.readLine());
      for (int j = 1; j <= w; j++) {
        arr[i][j] = Integer.parseInt(stk.nextToken());
      }
    }

    Queue<Pos> q = new LinkedList<>();
    q.add(new Pos(0, 0));
    while (!q.isEmpty()) {
      Pos pos = q.poll();
      for (int k = 0; k < 6; k++) {
        int hh = pos.h + dy[pos.h % 2][k];
        int ww = pos.w + dx[pos.h % 2][k];
        if (hh >= 0 && hh <= h + 1 && ww >= 0 && ww <= w + 1) {
          if (arr[hh][ww] == 0 && !isOut[hh][ww]) {
            isOut[hh][ww] = true;
            q.add(new Pos(hh, ww));
          }
        }
      }
    }

    for (int i = 1; i <= h; i++) {
      for (int j = 1; j <= w; j++) {
        if (arr[i][j] == 1) {
          for (int k = 0; k < 6; k++) {
            int hh = i + dy[i % 2][k];
            int ww = j + dx[i % 2][k];
            if (isOut[hh][ww]) {
              total += 1;
            }
          }
        }
      }
    }
    bw.write(total + "\n");
    bw.flush();
    bw.close();
  }

  public static class Pos {

    int h;
    int w;

    public Pos(int h, int w) {
      this.h = h;
      this.w = w;
    }
  }
}