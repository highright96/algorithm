public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[1001];
        solve();
        bw.write(arr[N] + "\n");
        bw.flush();
        bw.close();
    }

    static void solve() {
        arr[1] = 1;
        arr[2] = 3;
        for (int i = 3; i <= N; i++) {
            arr[i] = ((2 * arr[i - 2] % 10007) + (arr[i - 1] % 10007)) % 10007;
        }
    }
}