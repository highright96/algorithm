public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stk.nextToken());
    int m = Integer.parseInt(stk.nextToken());
    int[][] sum = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      stk = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        int num = Integer.parseInt(stk.nextToken());
        if (i == 1 && j == 1) {
          sum[i][j] = num;
        } else if (i == 1) {
          sum[i][j] = sum[i][j - 1] + num;
        } else if (j == 1) {
          sum[i][j] = sum[i - 1][j] + num;
        } else {
          sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + num;
        }
      }
    }

    while (m-- > 0) {
      stk = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(stk.nextToken());
      int y1 = Integer.parseInt(stk.nextToken());
      int x2 = Integer.parseInt(stk.nextToken());
      int y2 = Integer.parseInt(stk.nextToken());
      int result = sum[x2][y2] + sum[x1 - 1][y1 - 1] - sum[x2][y1 - 1] - sum[x1 - 1][y2];
      bw.write(result + "\n");
    }
    bw.flush();
    bw.close();
  }
}