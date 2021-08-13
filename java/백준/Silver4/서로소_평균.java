public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static long X;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong((stk.nextToken()));
        }
        X = Long.parseLong((br.readLine()));
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        long sum = 0, ans = 0, cnt = 0;
        for (long l : arr) {
            if (l > X) {
                ans = gcd(l, X);
            } else {
                ans = gcd(X, l);
            }
            if (ans == 1) {
                cnt += 1;
                sum += l;
            }
        }
        bw.write(sum / cnt + "\n");
    }

    static long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}