public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, K, S;
    private static ArrayList<Integer>[] graph;
    private static Queue<Integer> queue = new LinkedList<>();
    private static boolean[] visited;
    private static StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        while (K-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }

        dfs(S);
        bfs(S);
        bw.write(sb1.toString() + "\n" + sb2.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int nodeIdx) {
        visited[nodeIdx] = true;
        sb1.append(nodeIdx).append(" ");
        for (int node : graph[nodeIdx]) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    static void bfs(int nodeIdx) {
        visited = new boolean[N + 1];
        visited[nodeIdx] = true;
        queue.add(nodeIdx);
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            sb2.append(idx).append(" ");
            for (int node : graph[idx]) {
                if (!visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }
    }
}