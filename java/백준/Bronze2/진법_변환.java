public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String N;
    private static int B;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = stk.nextToken();
        B = Integer.parseInt(stk.nextToken());
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        int sum = 0;
        int n = 0;
        for (int i = 0; i < N.length(); i++) {
            if (N.charAt(i) >= 65) {
                n = N.charAt(i) - 55;
            } else {
                n = N.charAt(i) - '0';
            }
            sum += (n * Math.pow(B, N.length() - i - 1));
        }
        bw.write(String.valueOf(sum));
    }
}