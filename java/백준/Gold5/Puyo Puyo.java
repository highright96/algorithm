public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static char[][] field = new char[12][6];
  static List<Pos> list = new ArrayList<>();

  static int[] dy = {-1, 0, 1, 0}; //상 우 하 좌
  static int[] dx = {0, 1, 0, -1};
  static int ans = 0;

  public static void main(String[] args) throws IOException {
    for (int i = 0; i < 12; i++) {
      String s = br.readLine();
      for (int j = 0; j < 6; j++) {
        char c = s.charAt(j);
        field[i][j] = c;
      }
    }
    while (true) {
      boolean isChk = false;
      for (int i = 0; i < 12; i++) {
        for (int j = 0; j < 6; j++) {
          if (field[i][j] != '.') {
            list.clear();
            boolean[][] visited = new boolean[12][6];
            list.add(new Pos(i, j));
            dfs(field[i][j], visited, i, j);
            if (list.size() >= 4) {
              isChk = true;
              //터트리기
              for (Pos p : list) {
                field[p.y][p.x] = '.';
              }
            }
          }
        }
      }
      if (!isChk) {
        break;
      }
      //밑으로 내리기
      down();
      ans += 1;
    }
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }

  static void dfs(char c, boolean[][] visited, int y, int x) {
    visited[y][x] = true;
    for (int i = 0; i < 4; i++) {
      int yy = dy[i] + y;
      int xx = dx[i] + x;
      if (yy >= 0 && xx >= 0 && yy < 12 && xx < 6) {
        if (field[yy][xx] == c && !visited[yy][xx]) {
          visited[yy][xx] = true;
          list.add(new Pos(yy, xx));
          dfs(c, visited, yy, xx);
        }
      }
    }
  }

  static void down() {
    while (true) {
      boolean isChk = false;
      for (int i = 0; i < 12; i++) {
        for (int j = 0; j < 6; j++) {
          if (field[i][j] != '.') {
            if (i + 1 < 12 && field[i + 1][j] == '.') {
              field[i + 1][j] = field[i][j];
              field[i][j] = '.';
              isChk = true;
            }
          }
        }
      }
      if (!isChk) {
        break;
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