/*
백준 골드4
문제 유형 : 그래프 탐색, 구현
걸린 시간 : 40분
*/
public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dy = {0, 0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dx = {0, 1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        char[][] initChess = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                initChess[i][j] = line.charAt(j);
            }
        }

        int ans = bfs(new Node(0, 7, initChess));

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

    static int bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Node prev = queue.poll();
            char[][] tmp = deepCopy(prev.chess);
            down(tmp);
            for (int i = 0; i < 9; i++) {
                int nx = dx[i] + prev.x;
                int ny = dy[i] + prev.y;

                if(nx == 7 && ny == 0) return 1;

                if(nx >= 0 && ny >= 0 && nx < 8 && ny < 8) {
                    if(prev.chess[ny][nx] != '#' && tmp[ny][nx] != '#') {
                        queue.offer(new Node(nx, ny, tmp));
                    }
                }
            }
        }
        return 0;
    }

    static void down(char[][] chess) {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (i != 7) {
                    chess[i + 1][j] = chess[i][j];
                }
                chess[i][j] = '.';
            }
        }
    }

    static char[][] deepCopy(char[][] target) {
        char[][] result = new char[8][8];
        for(int i=0; i<target.length; i++){
            System.arraycopy(target[i], 0, result[i], 0, 8);
        }
        return result;
    }

    static class Node {

        int x, y;
        char[][] chess;

        public Node(int x, int y, char[][] chess) {
            this.x = x;
            this.y = y;
            this.chess = chess;
        }
    }
}