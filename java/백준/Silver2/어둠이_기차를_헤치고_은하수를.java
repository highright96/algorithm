public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, cmd, t, x;
    private static int[][] arr;
    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = parseInt(stk.nextToken());
        m = parseInt(stk.nextToken());
        arr = new int[n + 1][21];
        for (int j = 0; j < m; j++) {
            stk = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(stk.nextToken());
            if (cmd == 1 || cmd == 2) {
                t = Integer.parseInt(stk.nextToken());
                x = Integer.parseInt(stk.nextToken());
            } else {
                t = Integer.parseInt(stk.nextToken());
            }
            solution();
        }
        for (int j = 1; j <= n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 1; k <= 20; k++) {
                sb.append(arr[j][k]);
            }
            set.add(sb.toString());
        }
        bw.write(set.size() + "\n");
        bw.flush();
        bw.close();
    }

    static void solution() {
        if (cmd == 1) {
            arr[t][x] = 1;
        } else if (cmd == 2) {
            arr[t][x] = 0;
        } else if (cmd == 3) {
            for (int j = 20; j > 1; j--) {
                arr[t][j] = arr[t][j - 1];
            }
            arr[t][1] = 0;
        } else {
            for (int j = 1; j < 20; j++) {
                arr[t][j] = arr[t][j + 1];
            }
            arr[t][20] = 0;
        }
    }
}