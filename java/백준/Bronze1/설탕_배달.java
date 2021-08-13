public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, ans = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        Arrays.fill(arr, 0);
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        if (N < 5) {
            if (N == 3) {
                ans = 1;
            } else {
                ans = -1;
            }
        } else {
            arr[3] = 1;
            arr[5] = 1;
            dp();
        }
        bw.write(ans + "\n");
    }

    static void dp() {
        for (int i = 6; i < arr.length; i++) {
            if (arr[i - 3] == 0 && arr[i - 5] != 0) {
                arr[i] = arr[i - 5] + 1;
            } else if (arr[i - 3] != 0 && arr[i - 5] == 0) {
                arr[i] = arr[i - 3] + 1;
            } else if (arr[i - 3] != 0 && arr[i - 5] != 0) {
                int tmp = Math.min(arr[i - 3], arr[i - 5]);
                arr[i] = tmp + 1;
            } else {
                arr[i] = 0;
            }
        }
        ans = arr[N] == 0 ? -1 : arr[N];
    }
}