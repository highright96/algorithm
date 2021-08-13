public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Set<String> set = new HashSet<>();
    private static String[] arr;
    private static String str;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        arr = new String[n + 1];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            str = stk.nextToken();
            set.add(str);
        }

        while (m-- > 0) {
            stk = new StringTokenizer(br.readLine());
            str = stk.nextToken();
            solve();
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        if (set.contains(str)) {
            cnt += 1;
        }
    }
}