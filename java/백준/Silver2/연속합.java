public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, max;
    private static int[] val, sum;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        val = new int[N];
        sum = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }
        solve();
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    static void solve() {
        max = val[0];
        sum[0] = val[0];
        for (int i = 1; i < N; i++) {
            if (sum[i - 1] > 0) {
                sum[i] = sum[i - 1] + val[i];
                max = Math.max(max, sum[i]);
            } else {
                sum[i] = val[i];
                max = Math.max(max, sum[i]);
            }
        }
    }
}