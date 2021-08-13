public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            M = Integer.parseInt(br.readLine());
            arr = new int[3][M + 1];
            dp = new int[3][M + 1];

            for (int i = 1; i <= 2; i++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                for (int j = 1; j <= M; j++) {
                    arr[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
            solve();
            bw.write(Math.max(dp[1][M], dp[2][M]) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void solve() {
        dp[1][1] = arr[1][1];
        dp[2][1] = arr[2][1];

        for (int i = 2; i <= M; i++) {
            dp[1][i] = Math.max(dp[2][i - 1], dp[2][i - 2]) + arr[1][i];
            dp[2][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[2][i];
        }
    }
}