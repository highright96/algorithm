/*
백준 실버 1
문제 유형 : BFS
걸린 시간 : 1시간
*/
public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] game;
    static boolean[][] visited;
    static int n;
    static int dx[] = {1, 0}, dy[] = {0, 1};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        game = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                game[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        bw.write(bfs(new Pos(0, 0)));
        bw.flush();
        bw.close();
    }

    static String bfs(Pos pos) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(pos);
        visited[pos.y][pos.x] = true;
        while (!q.isEmpty()) {
            Pos p = q.poll();
            int v = game[p.y][p.x];
            if (v == -1) {
                return "HaruHaru";
            }
            for (int i = 0; i < 2; i++) {
                int ny = p.y + v * dy[i];
                int nx = p.x + v * dx[i];
                if (ny < n && nx < n && !visited[ny][nx]) {
                    q.offer(new Pos(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
        return "Hing";
    }

    static class Pos {

        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}