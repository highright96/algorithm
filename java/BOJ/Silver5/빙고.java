public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] arr = new int[7][7];
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 5; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 1; i <= 5; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                int num = Integer.parseInt(stk.nextToken());
                solve(num);
                if (cnt >= 3) {
                    bw.write((i - 1) * 5 + j + "\n");
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
    }

    static void solve(int num) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (arr[i][j] == num) {
                    arr[0][j] += 1; //세로
                    cnt += arr[0][j] == 5 ? 1 : 0;
                    arr[i][0] += 1; //가로
                    cnt += arr[i][0] == 5 ? 1 : 0;
                    if (i == j) {
                        arr[0][0] += 1; //왼쪽 대각선
                        cnt += arr[0][0] == 5 ? 1 : 0;
                    }
                    if ((i == 5 && j == 1) || (i == 1 && j == 5) ||
                        (i == 4 && j == 2) || (i == 2 && j == 4) || (i == 3 && j == 3)) {
                        arr[0][6] += 1; //오른쪽 대각선
                        cnt += arr[0][6] == 5 ? 1 : 0;
                    }
                    return;
                }
            }
        }
    }
}