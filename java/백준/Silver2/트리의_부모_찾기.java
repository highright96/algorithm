public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] parent;
    private static boolean[] visit;
    private static ArrayList<Integer>[] graph;
    private static int a, b;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        parent = new int[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        while (n-- > 1) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        solve();
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        parent[1] = 1;
        visit[1] = true;
        dfs(1);
        for (int i = 2; i < parent.length; i++) {
            bw.write(parent[i] + "\n");
        }
    }

    public static void dfs(int p) {
        for (int c : graph[p]) {
            if (!visit[c]) {
                parent[c] = p;
                visit[c] = true;
                dfs(c);
            }
        }
    }
}