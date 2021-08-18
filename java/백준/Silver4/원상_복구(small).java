public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, K;
    private static int[] P, D, C;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        P = new int[N + 1];
        D = new int[N + 1];
        C = new int[N + 1];

        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(stk.nextToken());
        }
        solution();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solution() {
        while (K-- > 0) {
            for (int j = 1; j <= N; j++) {
                C[j] = P[D[j]];
            }
            P = Arrays.copyOfRange(C, 0, C.length + 1);
        }
        for (int i = 1; i <= N; i++) {
            sb.append(P[i]).append(" ");
        }
    }
}