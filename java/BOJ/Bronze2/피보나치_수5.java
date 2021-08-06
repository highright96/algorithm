public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        int ans = fibo(N);
        bw.write(ans + "\n");
    }

    static int fibo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}