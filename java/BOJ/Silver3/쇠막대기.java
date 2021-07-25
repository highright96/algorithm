public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Stack<String> stack = new Stack<>();
    private static String str;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        str = stk.nextToken();
        solve();
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        int stick = 0, piece = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stick += 1;
            } else {
                if (str.charAt(i - 1) == '(') {
                    stick -= 1;
                    piece += stick;
                } else {
                    piece += 1;
                    stick -= 1;
                }
            }
        }
        bw.write(valueOf(piece));
    }
}