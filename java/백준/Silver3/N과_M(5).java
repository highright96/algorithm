public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] arr, num;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[m];
        num = new int[n];
        visited = new boolean[n];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(num);
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
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[k] = num[i];
                solutions(k + 1);
                visited[i] = false;
            }
        }
    }
}