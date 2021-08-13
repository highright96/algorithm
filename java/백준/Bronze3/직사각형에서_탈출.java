public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int x, y, w, h;

    public static void main(String[] args) throws IOException {

        StringTokenizer stk = new StringTokenizer(br.readLine());
        x = Integer.parseInt(stk.nextToken());
        y = Integer.parseInt(stk.nextToken());
        w = Integer.parseInt(stk.nextToken());
        h = Integer.parseInt(stk.nextToken());
        solve();

        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        List<Integer> list = Arrays.asList(x, y, w - x, h - y);
        bw.write(valueOf(Collections.min(list)));
    }
}