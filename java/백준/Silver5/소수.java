public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        int sum = 0, cnt = 0, min = 0;
        for (int i = n; i <= m; i++) {
            if (isPrime(i)) {
                sum += i;
                cnt += 1;
                if (cnt == 1) {
                    min = i;
                }
            }
        }
        if (sum == 0) {
            bw.write("-1");
            return;
        }
        bw.write(sum + "\n");
        bw.write(min + "\n");
    }

    static boolean isPrime(int k) {
        if (k < 2) {
            return false;
        }
        int root = (int) Math.sqrt(k);
        for (int i = 2; i <= root; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }
}