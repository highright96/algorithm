public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int n, m, ans = 0;
  private static int[][] num;
  private static boolean[][] chk;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(stk.nextToken());
    m = Integer.parseInt(stk.nextToken());
    num = new int[n + 1][m + 1];
    chk = new boolean[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      stk = new StringTokenizer(br.readLine());
      for (int j = 1; j <= m; j++) {
        chk[i][j] = true;
        num[i][j] = Integer.parseInt(stk.nextToken());
      }
    }
    solution(1, 1, 0, 0);
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }

  public static void solution(int y, int x, int c, int sum) {
    if (c == n * m) {
      ans = Math.max(sum, ans);
      return;
    }

    if (x == m + 1) {
      y++;
      x = 1;
    }

    // ㄱ
    if (chk[y][x] && chk[y - 1][x] && chk[y - 1][x - 1]) {
      chk[y][x] = false;
      chk[y - 1][x] = false;
      chk[y - 1][x - 1] = false;
      solution(y, x + 1, c + 1, sum + num[y][x] + 2 * num[y - 1][x] + num[y - 1][x - 1]);
      chk[y][x] = true;
      chk[y - 1][x] = true;
      chk[y - 1][x - 1] = true;
    }
    // ㄴ
    if (chk[y][x] && chk[y][x - 1] && chk[y - 1][x - 1]) {
      chk[y][x] = false;
      chk[y][x - 1] = false;
      chk[y - 1][x - 1] = false;
      solution(y, x + 1, c + 1, sum + num[y][x] + 2 * num[y][x - 1] + num[y - 1][x - 1]);
      chk[y][x] = true;
      chk[y][x - 1] = true;
      chk[y - 1][x - 1] = true;
    }
    // 역 ㄱ
    if (chk[y - 1][x] && chk[y][x - 1] && chk[y - 1][x - 1]) {
      chk[y - 1][x] = false;
      chk[y][x - 1] = false;
      chk[y - 1][x - 1] = false;
      solution(y, x + 1, c + 1, sum + num[y - 1][x] + 2 * num[y - 1][x - 1] + num[y][x - 1]);
      chk[y - 1][x] = true;
      chk[y][x - 1] = true;
      chk[y - 1][x - 1] = true;
    }
    // 역 ㄴ
    if (chk[y][x - 1] && chk[y][x] && chk[y - 1][x]) {
      chk[y][x] = false;
      chk[y][x - 1] = false;
      chk[y - 1][x] = false;
      solution(y, x + 1, c + 1, sum + num[y - 1][x] + 2 * num[y][x] + num[y][x - 1]);
      chk[y][x] = true;
      chk[y][x - 1] = true;
      chk[y - 1][x] = true;
    }
    // 그냥 넘어가기
    solution(y, x + 1, c + 1, sum);
  }
}