public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = parseInt(stk.nextToken());
        m = parseInt(stk.nextToken());
        arr = new int[n + 2][m + 2];
        visited = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = s.charAt(j - 1) - '0';
            }
        }
        bfs(1, 1);
        bw.write(arr[n][m] + "\n");
        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int xx = pos.x + dx[i];
                int yy = pos.y + dy[i];
                if (arr[xx][yy] >= 1 && !visited[xx][yy]) {
                    visited[xx][yy] = true;
                    queue.add(new Pos(xx, yy));
                    arr[xx][yy] = arr[pos.x][pos.y] + 1;
                }
            }
        }
    }
}