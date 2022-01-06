public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> num = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num.add(Integer.parseInt(stk.nextToken()));
        }
        num.sort(null);
        back(0);
        bw.flush();
        bw.close();
    }

    public static void back(int depth) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                arr[depth] = num.get(i);
                visited[i] = true;
                back(depth + 1);
                visited[i] = false;
            }
        }
    }
}