public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        solve();
        bw.write(arr[N] + "\n");
        bw.flush();
        bw.close();
    }

    static void solve() {
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }
    }
}