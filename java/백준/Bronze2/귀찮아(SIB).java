public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static long ans = 0;
    private static int[] arr, sum;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        sum = new int[n + 1];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }
        solution();
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    static void solution() {
        for (int i = 1; i < n; i++) {
            ans += (long) arr[i] * (sum[n] - sum[i]);
        }
    }
}