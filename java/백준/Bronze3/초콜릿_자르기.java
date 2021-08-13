public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int x, y;

    public static void main(String[] args) throws IOException {

        StringTokenizer stk = new StringTokenizer(br.readLine());
        x = Integer.parseInt(stk.nextToken());
        y = Integer.parseInt(stk.nextToken());
        solve();

        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        bw.write(valueOf(x * y - 1));
    }
}