public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[][] board = new int[9][9];
  private static List<Pos> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    for (int i = 0; i < 9; i++) {
      StringTokenizer stk = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        int num = Integer.parseInt(stk.nextToken());
        board[i][j] = num;
        if (num == 0) {
          list.add(new Pos(i, j));
        }
      }
    }
    solution(0);
  }

  static void solution(int idx) throws IOException {
    if (idx == list.size()) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          bw.write(board[i][j] + " ");
        }
        bw.write("\n");
      }
      bw.flush();
      bw.close();
      System.exit(0);
    }
    Pos pos = list.get(idx);
    for (int i = 1; i <= 9; i++) {
      if (check(i, pos.x, pos.y)) {
        board[pos.x][pos.y] = i;
        solution(idx + 1);
        board[pos.x][pos.y] = 0;
      }
    }
  }

  static boolean check(int v, int x, int y) {
    //가로, 세로
    for (int i = 0; i < 9; i++) {
      if (board[x][i] == v || board[i][y] == v) {
        return false;
      }
    }
    //3x3
    int sy = (y / 3) * 3;
    int sx = (x / 3) * 3;
    for (int i = sx; i <= sx + 2; i++) {
      for (int j = sy; j <= sy + 2; j++) {
        if (board[i][j] == v) {
          return false;
        }
      }
    }
    return true;
  }

  static class Pos {

    int x;
    int y;

    public Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}