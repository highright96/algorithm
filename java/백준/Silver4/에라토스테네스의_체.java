public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int a, b;
    private static boolean[] delete;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        a = Integer.parseInt(stk.nextToken());
        b = Integer.parseInt(stk.nextToken());
        delete = new boolean[a + 1];
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        int cnt = 0;
        for (int i = 2; i <= a; i++) {
            if (!delete[i]) {
                int k = i;
                while (k <= a) {
                    if (!delete[k]) {
                        delete[k] = true;
                        cnt += 1;
                        if (cnt == b) {
                            bw.write(k + "\n");
                            return;
                        }
                    }
                    k += i;
                }
            }
        }
    }
}