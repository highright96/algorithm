public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, size;
    private static List<Integer> ans = new ArrayList<>();
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {1, 0, -1, 0}; //하우상좌
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 2][n + 2];
        visited = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                arr[i][j] = s.charAt(j - 1) - '0';
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    size = 1;
                    dfs(i, j);
                    ans.add(size);
                }
            }
        }
        ans.sort(Comparator.naturalOrder());
        bw.write(ans.size() + "\n");
        for (int i : ans) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (arr[xx][yy] == 1 && !visited[xx][yy]) {
                size += 1;
                dfs(xx, yy);
            }
        }
    }
}