public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, ans = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        solution();
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    static void solution() {
        for (int i = 0; i <= n; i++) {
            int sum = 0, num = i;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }

            if (i + sum == n) {
                ans = i;
                return;
            }
        }
    }
}