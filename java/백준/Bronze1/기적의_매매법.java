public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;
    private static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[15];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 14; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        int b = N, br = 0;
        for (int i = 1; i <= 14; i++) {
            if (b >= arr[i]) {
                br += b / arr[i];
                b %= arr[i];
            }
        }

        int t = N, tr = 0, up = 0, down = 0;
        for (int i = 2; i <= 14; i++) {
            if (arr[i - 1] > arr[i]) {
                down += 1;
                up = 0;
            } else if (arr[i] > arr[i - 1]) {
                up += 1;
                down = 0;
            } else {
                up = 0;
                down = 0;
            }

            if (up == 3) {
                if (tr > 0) {
                    t += tr * arr[i]; //전부 판매
                    tr = 0; // 수량 초기화
                }
            } else if (down >= 3) {
                if (t >= arr[i]) {
                    tr += t / arr[i]; // 구매 수량
                    t %= arr[i]; // 구매 후 남은 돈
                }
            }
        }
        if (arr[14] * br + b > arr[14] * tr + t) {
            bw.write("BNP");
        } else if (arr[14] * br + b < arr[14] * tr + t) {
            bw.write("TIMING");
        } else {
            bw.write("SAMESAME");
        }
    }
}