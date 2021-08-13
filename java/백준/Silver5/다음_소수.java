public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Long n, m;

    public static void main(String[] args) throws IOException {
        n = Long.parseLong(br.readLine());
        while (n-- > 0) {
            m = Long.parseLong(br.readLine());
            solve();
        }
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        while (true) {
            if (isPrime(m)) {
                bw.write(m + "\n");
                return;
            }
            m += 1;
        }
    }

    static boolean isPrime(Long k) {
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