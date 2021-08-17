public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long N, ans = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Long.parseLong(br.readLine());
        solution();
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    static void solution() {
        long left = 0, right = N, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            long sum = (long) Math.pow(mid, 2);
            if (sum >= N) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else if (sum < N) {
                left = mid + 1;
            }
        }
    }
}