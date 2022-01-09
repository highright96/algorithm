public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer>[] graph;
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        int c = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        graph = new ArrayList[c + 1];
        visited = new boolean[c + 1];

        for (int i = 0; i < c + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < b; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            graph[n].add(m);
            graph[m].add(n);
        }
        bfs(1);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    public static void bfs(int nodeIdx) {
        visited[nodeIdx] = true;
        for (int node : graph[nodeIdx]) {
            if (!visited[node]) {
                ans++;
                bfs(node);
            }
        }
    }
}