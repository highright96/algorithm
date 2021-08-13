public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, ans;
    private static int[] arr, sum;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        sum = new int[N + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        solve();
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    static void solve() {
        sum[1] = arr[1];
        ans = sum[1];
        for (int i = 2; i <= N; i++) {
            sum[i] = arr[i];
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    sum[i] = Math.max(sum[i], sum[j] + arr[i]);
                }
            }
            ans = Math.max(ans, sum[i]);
        }
    }
}