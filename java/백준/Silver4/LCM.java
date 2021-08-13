public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static Long a, b;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a = Long.parseLong(stk.nextToken());
            b = Long.parseLong(stk.nextToken());
            solve();
        }
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        Long result = 0L;
        if (a > b) {
            result = gcd(a, b);
        } else {
            result = gcd(b, a);
        }
        Long ans = a * b / result;
        bw.write(ans + "\n");
    }

    static Long gcd(Long a, Long b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}