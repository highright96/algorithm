public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] arr;
    private static int N, M, ansX, ansY;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], 0);
        }
        solve();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write(ansX + " " + ansY);
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        int dir = 0; //0 아래, 1 오른쪽, 2 위, 3 왼쪽
        int x = 0, y = 0;
        for (int i = N * N; i > 0; i--) {
            if (i == M) {
                ansX = y + 1;
                ansY = x + 1;
            }
            if (dir == 0) {
                if (y < N && arr[y][x] == 0) {
                    arr[y][x] = i;
                    y += 1;
                } else {
                    y -= 1;
                    x += 1;
                    i += 1;
                    dir = 1;
                }
            } else if (dir == 1) {
                if (x < N && arr[y][x] == 0) {
                    arr[y][x] = i;
                    x += 1;
                } else {
                    x -= 1;
                    y -= 1;
                    i += 1;
                    dir = 2;
                }
            } else if (dir == 2) {
                if (y >= 0 && arr[y][x] == 0) {
                    arr[y][x] = i;
                    y -= 1;
                } else {
                    x -= 1;
                    y += 1;
                    i += 1;
                    dir = 3;
                }
            } else if (dir == 3) {
                if (x >= 0 && arr[y][x] == 0) {
                    arr[y][x] = i;
                    x -= 1;
                } else {
                    x += 1;
                    y += 1;
                    i += 1;
                    dir = 0;
                }
            }
        }
    }
}