public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] arr;
    private static int n, m, r;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        r = Integer.parseInt(stk.nextToken());
        arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        solution();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static void solution() {
        int cnt = Math.min(n, m) / 2;
        while (r-- > 0) {
            int g = m;
            int s = n;
            for (int i = 1; i <= cnt; i++) {
                int tmp = arr[i][i];
                for (int j = i; j < g; j++) {
                    arr[i][j] = arr[i][j + 1];
                }
                for (int j = i; j < s; j++) {
                    arr[j][g] = arr[j + 1][g];
                }
                for (int j = g; j > i; j--) {
                    arr[s][j] = arr[s][j - 1];
                }
                for (int j = s; j > i + 1; j--) {
                    arr[j][i] = arr[j - 1][i];
                }
                arr[i + 1][i] = tmp;
                g -= 1;
                s -= 1;
            }
        }
    }
}