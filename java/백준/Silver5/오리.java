public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;
    private static int cnt = 0;
    private static String str;

    public static void main(String[] args) throws IOException {
        str = br.readLine();
        arr = new int[5];
        Arrays.fill(arr, 0);
        solve();
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    static void solve() {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'q') {
                if (cnt > 0) {
                    cnt -= 1;
                }
                arr[0] += 1;
            } else if (str.charAt(i) == 'u') {
                if (arr[0] < arr[1] + 1) {
                    cnt = -1;
                    return;
                }
                arr[1] += 1;
            } else if (str.charAt(i) == 'a') {
                if (arr[1] < arr[2] + 1) {
                    cnt = -1;
                    return;
                }
                arr[2] += 1;
            } else if (str.charAt(i) == 'c') {
                if (arr[2] < arr[3] + 1) {
                    cnt = -1;
                    return;
                }
                arr[3] += 1;
            } else if (str.charAt(i) == 'k') {
                if (arr[3] < arr[4] + 1) {
                    cnt = -1;
                    return;
                }
                arr[4] += 1;
                cnt += 1;
            }
        }
        cnt = Arrays.stream(arr).sum() % 5 != 0 ? -1 : cnt;
    }
}