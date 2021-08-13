public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char[][] arr;
    private static char[][] ans;
    private static int N;
    private static boolean boom = false;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        ans = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                solve(i, j, s.charAt(j));
            }
        }
        ans = boom ? arr : ans;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(ans[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static void solve(int row, int col, char val) {
        int cnt = 0;
        if (val == 'x') {
            if (arr[row][col] == '.') {
                if (row == 0 && col == 0) {
                    //하, 우, 오른쪽 아래 대각선
                    cnt = check(1, row, col) + check(2, row, col) + check(3, row, col);
                } else if (row == 0 && col > 0 && col < N - 1) {
                    //왼, 오, 왼 아래 대각, 오 아래 대각, 아래
                    cnt = check(1, row, col) + check(2, row, col) + check(3, row, col)
                        + check(4, row, col) + check(5, row, col);
                } else if (row == N - 1 && col > 0 && col < N - 1) {
                    //왼, 오, 왼 위 대각, 오 위 대각, 위
                    cnt = check(2, row, col) + check(4, row, col) + check(6, row, col)
                        + check(7, row, col) + check(8, row, col);
                } else if (row == 0 && col == N - 1) {
                    //하, 좌, 왼쪽 아래 대각선
                    cnt = check(1, row, col) + check(4, row, col) + check(5, row, col);
                } else if (row == N - 1 && col == 0) {
                    //상, 우, 오른쪽 위 대각선
                    cnt = check(6, row, col) + check(2, row, col) + check(7, row, col);
                } else if (row == N - 1 && col == N - 1) {
                    //상, 좌, 왼쪽 위 대각선
                    cnt = check(6, row, col) + check(4, row, col) + check(8, row, col);
                } else if (row > 0 && row < N - 1 && col > 0 && col < N - 1) {
                    //모든 방향
                    cnt = check(1, row, col) + check(2, row, col) + check(3, row, col)
                        + check(4, row, col) + check(5, row, col) + check(6, row, col)
                        + check(7, row, col) + check(8, row, col);
                }
                ans[row][col] = String.valueOf(cnt).charAt(0);
            } else if (arr[row][col] == '*') {
                boom = true;
            }
        } else {
            ans[row][col] = '.';
        }
    }

    static int check(int dir, int row, int col) {
        if (dir == 1) { //하
            return arr[row + 1][col] == '*' ? 1 : 0;
        } else if (dir == 2) { //우
            return arr[row][col + 1] == '*' ? 1 : 0;
        } else if (dir == 3) { // 오른쪽 아래 대각선
            return arr[row + 1][col + 1] == '*' ? 1 : 0;
        } else if (dir == 4) { // 좌
            return arr[row][col - 1] == '*' ? 1 : 0;
        } else if (dir == 5) { // 왼쪽 아래 대각선
            return arr[row + 1][col - 1] == '*' ? 1 : 0;
        } else if (dir == 6) { // 상
            return arr[row - 1][col] == '*' ? 1 : 0;
        } else if (dir == 7) { // 오른쪽 위 대각선
            return arr[row - 1][col + 1] == '*' ? 1 : 0;
        } else if (dir == 8) { // 왼쪽 위 대각선
            return arr[row - 1][col - 1] == '*' ? 1 : 0;
        }
        return 0;
    }
}