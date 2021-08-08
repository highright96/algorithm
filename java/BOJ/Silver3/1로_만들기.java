public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        solve();
        bw.write(arr[N] + "\n");
        bw.flush();
        bw.close();
    }

    static void solve() {
        arr[0] = 0;
        arr[1] = 0;
        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                min = Math.min(min, arr[i / 3]);
            }
            if (i % 2 == 0) {
                min = Math.min(min, arr[i / 2]);
            }
            min = Math.min(min, arr[i - 1]);
            arr[i] = min + 1;
        }
    }
}