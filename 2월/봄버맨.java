/*
백준 Silver1
문제 유형 : 구현, 시뮬레이션, bfs
걸린 시간 : 30분
*/
public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(stk.nextToken()), c = Integer.parseInt(stk.nextToken()),n = Integer.parseInt(stk.nextToken());
        char[][] bomb = new char[r][c];
        int[][] time = new int[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                bomb[i][j] = s.charAt(j);
                if (bomb[i][j] == 'O') {
                    time[i][j] = 2;
                }
            }
        }

        for (int i = 1; i <= n - 1; i++) {
            decrease(bomb, time);
            explode(bomb, time);
            if (i % 2 != 0) {
                plant(bomb, time);
            }
        }
        draw(bomb);
        bw.flush();
        bw.close();
    }

    static void draw(char[][] bomb) throws IOException {
        for (int i = 0; i < bomb.length; i++) {
            for (int j = 0; j < bomb[i].length; j++) {
                bw.write(bomb[i][j]);
            }
            bw.newLine();
        }
    }

    static void plant(char[][] bomb, int[][] time) {
        for (int i = 0; i < bomb.length; i++) {
            for (int j = 0; j < bomb[i].length; j++) {
                if (bomb[i][j] == '.') {
                    bomb[i][j] = 'O';
                    time[i][j] = 3;
                }
            }
        }
    }

    static void decrease(char[][] bomb, int[][] time) {
        for (int i = 0; i < bomb.length; i++) {
            for (int j = 0; j < bomb[i].length; j++) {
                if (bomb[i][j] == 'O') {
                    time[i][j] -= 1;
                }
            }
        }
    }

    static void explode(char[][] bomb, int[][] time) {
        for (int i = 0; i < bomb.length; i++) {
            for (int j = 0; j < bomb[i].length; j++) {
                if (bomb[i][j] == 'O' && time[i][j] == 0) {
                    bomb[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k], nx = j + dx[k];
                        if (ny < 0 || ny >= bomb.length || nx < 0 || nx >= bomb[0].length) {
                            continue;
                        }
                        if (bomb[ny][nx] == 'O' && time[ny][nx] == 0) {
                            continue;
                        }
                        bomb[ny][nx] = '.';
                    }
                }
            }
        }
    }
}