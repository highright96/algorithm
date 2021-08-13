public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        int cnt = 0;
        int v = N;
        while (true) {
            N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
            cnt++;
            if (v == N) {
                bw.write(cnt + "\n");
                break;
            }
        }
    }
}