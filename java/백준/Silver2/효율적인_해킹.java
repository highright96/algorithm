public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, max = Integer.MIN_VALUE, cnt;
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        graph = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            cnt = 0;
            visited = new boolean[N + 1];
            dfs(i);
            if (cnt > max) {
                max = cnt;
                sb.delete(0, sb.length());
                sb.append(i).append(" ");
            } else if (cnt == max) {
                sb.append(i).append(" ");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }

    static void dfs(int nodeIdx) {
        visited[nodeIdx] = true;
        for (int node : graph[nodeIdx]) {
            if (!visited[node]) {
                cnt += 1;
                dfs(node);
            }
        }
    }
}