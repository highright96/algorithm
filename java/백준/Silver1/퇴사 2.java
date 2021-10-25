public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    int[] T = new int[N + 2];
    int[] P = new int[N + 2];
    int[] dp = new int[N + 2];
    for (int i = 1; i <= N; i++) {
      StringTokenizer stk = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(stk.nextToken());
      P[i] = Integer.parseInt(stk.nextToken());
    }

    for (int i = N; i >= 1; i--) {
      if (i + T[i] > N + 1) {
        dp[i] = dp[i + 1];
      } else {
        int w1 = P[i] + dp[i + T[i]]; //상담을 하는 경우
        int w2 = dp[i + 1]; // 상담을 하지 않는 경우
        dp[i] = Math.max(w1, w2);
      }
    }
    bw.write(dp[1] + "");
    bw.flush();
    bw.close();
  }
}