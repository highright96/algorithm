public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String N;
    private static StringBuilder ans, sb;

    public static void main(String[] args) throws IOException {
        N = br.readLine();
        ans = new StringBuilder();
        solve();
        bw.write(ans.toString());
        bw.flush();
        bw.close();
    }

    static void solve() {
        for (int i = 0; i < N.length(); i++) {
            sb = new StringBuilder();
            int n = N.charAt(i) - '0';
            for (int j = 1; j <= 3; j++) {
                int r = n % 2;
                n = n / 2;
                sb.append(r);
            }
            if (i == 0) {
                if (sb.charAt(2) == '0') {
                    sb.deleteCharAt(2);
                    if (sb.charAt(1) == '0') {
                        sb.deleteCharAt(1);
                    }
                }
            }
            ans.append(sb.reverse().toString());
        }
    }
}