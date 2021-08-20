public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] arr;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[n + 1];
        isVisited = new boolean[n + 1];
        solution(0);
        bw.flush();
        bw.close();
    }

    static void solution(int k) throws IOException {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                arr[k] = i;
                isVisited[i] = true;
                solution(k + 1);
                isVisited[i] = false;
                
            }
        }
    }
}