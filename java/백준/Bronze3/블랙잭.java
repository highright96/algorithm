public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, max = Integer.MIN_VALUE;
    private static int[] arr;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        isVisited = new boolean[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        solution(0, 0);
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    static void solution(int k, int sum) {
        if (k == 3) {
            if (sum <= m) {
                max = Math.max(max, sum);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                solution(k + 1, sum += arr[i]);
                sum -= arr[i];
                isVisited[i] = false;
            }
        }
    }
}