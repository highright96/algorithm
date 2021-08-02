public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        int min = Arrays.stream(arr).min().getAsInt();
        int i = 0;
        while (i <= min) {
            i += 1;
            boolean b = true;
            for (int v : arr) {
                if (v % i != 0) {
                    b = false;
                }
            }
            if (b) {
                bw.write(i + "\n");
            }
        }
    }
}