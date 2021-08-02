public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;
    private static int n, m;
    private static StringBuffer[] sb;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = (int) (Math.pow(2, n) - 1);
        arr = new int[m];
        sb = new StringBuffer[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        for (int i = 0; i < n; i++) {
            sb[i] = new StringBuffer();
        }
        solve();
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        search(0, arr.length-1, 0);
        for (int i = 0; i < n; i++) {
            bw.write(sb[i].toString() + "\n");
        }
    }

    public static void search(int start, int end, int floor) {
        if (floor == n) {
            return;
        }
        int index = (start + end) / 2;
        sb[floor].append(arr[index]).append(" ");
        search(start, index - 1, floor + 1);
        search(index + 1, end, floor + 1);
    }
}