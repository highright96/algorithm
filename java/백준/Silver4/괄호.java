public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static String str;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            str = stk.nextToken();
            solve();
        }
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            cnt += c == '(' ? 1 : -1;
            if (cnt < 0) {
                bw.write("NO\n");
                return;
            }
        }
        if (cnt > 0) {
            bw.write("NO\n");
        } else {
            bw.write("YES\n");
        }
    }
}