public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, K;
    private static int[] P, D;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        D = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solution();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solution() {
        while (K-- > 0) {
            int[] C = new int[N];
            for (int i = 0; i < N; i++) {
                C[D[i] - 1] = P[i];
            }
            P = C;
        }
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(" ");
        }
    }
}