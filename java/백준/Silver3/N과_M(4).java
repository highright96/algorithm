public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[m];
        solutions(0);
        bw.flush();
        bw.close();
    }

    static void solutions(int k) throws IOException {
        if (k == m) {
            for (int i : arr) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (k == 0 || arr[k - 1] <= i) {
                arr[k] = i;
                solutions(k + 1);
            }
        }
    }
}