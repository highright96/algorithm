public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int n, cost = 0, m = 3, ans = Integer.MAX_VALUE;
  private static int[][] num;
  private static boolean[][] plant;
  private static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {0, 0}}; //상 우 하 좌 y x

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(stk.nextToken());
    num = new int[n + 2][n + 2];
    plant = new boolean[n + 2][n + 2];
    for (int i = 1; i <= n; i++) {
      stk = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        plant[i][j] = true;
        num[i][j] = Integer.parseInt(stk.nextToken());
      }
    }
    solution(0, 0);
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }

  public static void solution(int c, int sum) {
    if (c == n * n) {
      if (m == 0) {
        ans = Math.min(sum, ans);
      }
      return;
    }

    int y = c / n + 2;
    int x = c % n + 2;
    cost = 0;
    boolean isPlant = checkIsPlant(y, x);

    if (isPlant) {
      updatePlant(y, x, false);
      m--;
      if (m == 0) {
        // 모든 씨앗을 심은 경우
        solution(n * n, sum + cost);
      } else {
        solution(c + 1, sum + cost);
      }
      updatePlant(y, x, true);
      m++;
    }
    solution(c + 1, sum);
  }

  // 꽃을 심을 수 있는지 확인
  public static boolean checkIsPlant(int y, int x) {
    for (int i = 0; i < 5; i++) {
      int dy = y + dir[i][0];
      int dx = x + dir[i][1];
      cost += num[dy][dx];
      if (!plant[dy][dx]) {
        return false;
      }
    }
    return true;
  }

  // 꽃을 심은 위치를 체크한다.
  public static void updatePlant(int y, int x, boolean isPlant) {
    for (int i = 0; i < 5; i++) {
      plant[y + dir[i][0]][x + dir[i][1]] = isPlant;
    }
  }
}