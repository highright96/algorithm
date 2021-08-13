public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        gcd(N, M);
        m = M * N / n;
        bw.write(n + "\n");
        bw.write(m + "\n");
    }

    static void gcd(int N, int M) {
        if (N % M == 0) {
            n = M;
            return;
        }
        gcd(M, N % M);
    }
}