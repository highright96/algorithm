public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int n, m, ans = 0;
  private static int[][] num;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(stk.nextToken());
    m = Integer.parseInt(stk.nextToken());
    num = new int[n + 1][m + 1];
    solution(1, 1, 0);
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }

  public static void solution(int y, int x, int c) {
    // 모든 칸에 네모네모를 넣거나 넣지 않았으면 ans 를 올려준다.
    if (c == n * m) {
      ans++;
      return;
    }

    //y, x 좌표를 변경해준다.
    if (x == m + 1) {
      y++;
      x = 1;
    }

    if (num[y][x - 1] == 1 && num[y - 1][x - 1] == 1 && num[y - 1][x] == 1) {
      solution(y, x + 1, c + 1);
    } else {
      //네모네모를 놓을 경우
      num[y][x] = 1;
      solution(y, x + 1, c + 1);

      //네모네모를 놓지 않을 경우
      num[y][x] = 0;
      solution(y, x + 1, c + 1);
    }
  }
}