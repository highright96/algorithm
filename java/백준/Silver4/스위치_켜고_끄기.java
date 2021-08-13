public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            solution(a, b);
        }
        for (int i = 1; i <= N; i++) {
            bw.write(arr[i] + " ");
            if (i % 20 == 0) {
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void solution(int a, int b) {
        if (a == 1) {
            for (int i = b; i <= N; i += b) {
                arr[i] = (arr[i] == 0) ? 1 : 0;
            }
        } else if (a == 2) {
            int left = b - 1, right = b + 1;
            arr[b] = arr[b] == 1 ? 0 : 1;
            while (left >= 1 && right <= N && arr[left] == arr[right]) {
                arr[left] = arr[left] == 1 ? 0 : 1;
                arr[right] = arr[right] == 1 ? 0 : 1;
                left -= 1;
                right += 1;
            }
        }
    }
}