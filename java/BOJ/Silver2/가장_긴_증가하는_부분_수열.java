public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, ans;
    private static int[] val;
    private static int[] len;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        val = new int[1001];
        len = new int[1001];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }
        solve();
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    static void solve() {
        len[1] = 1;
        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (val[i] > val[j]) {
                    max = Math.max(max, len[j]);
                }
            }
            len[i] = max + 1;
            ans = Math.max(ans, len[i]);
        }
    }
}