/*
백준 Gold5
문제 유형 : 구현, 시뮬레이션, bfs
걸린 시간 : 2시간 이상
*/
public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
    static int n, m;
    static int[][] tomatoes;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        tomatoes = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tomatoes[i][j] = Integer.parseInt(stk.nextToken());
                if (tomatoes[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }
        bfs();
        int max = Integer.MIN_VALUE;
        boolean isStop = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tomatoes[i][j] == 0) {
                    isStop = true;
                    break;
                }
                max = Math.max(max, tomatoes[i][j]);
            }
            if (isStop) {
                max = -1;
                break;
            }
        }
        bw.write(max - 1 + "");
        bw.flush();
        bw.close();
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int y = p[0], x = p[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if (ny >= 0 && ny < m && nx >= 0 && nx < n && !visited[ny][nx] && tomatoes[ny][nx] != -1) {
                    q.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    tomatoes[ny][nx] = tomatoes[y][x] + 1;
                }
            }
        }
    }
}