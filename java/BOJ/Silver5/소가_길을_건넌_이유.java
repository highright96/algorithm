public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, cnt = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        Arrays.fill(arr, -1);
        while (N-- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(stk.nextToken());
            int num = Integer.parseInt(stk.nextToken());
            solve(cow, num);
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    static void solve(int cow, int num) {
        if (arr[cow] == -1) {
            arr[cow] = num;
        } else if (arr[cow] != num) {
            cnt += 1;
            arr[cow] = num;
        }
    }
}