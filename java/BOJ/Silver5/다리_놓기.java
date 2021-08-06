public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, a, b;
    private static double ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            solve();
        }
        bw.flush();
        bw.close();
    }

    static void solve() {
        if (a == b) {
            ans = 1;
        } else {
            ans = factorial(b) / (factorial(b - a) * factorial(a));
        }
        System.out.printf("%.0f\n", ans);
    }

    static double factorial(double n) {
        if (n <= 1) {
            return n;
        }
        return factorial(n - 1) * n;
    }
}