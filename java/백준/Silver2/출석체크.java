public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] chk, sleep;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = parseInt(stk.nextToken());
        int k = parseInt(stk.nextToken());
        int q = parseInt(stk.nextToken());
        int m = parseInt(stk.nextToken());

        arr = new int[n + 3];
        chk = new boolean[5005];
        sleep = new boolean[5005];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int idx = Integer.parseInt(stk.nextToken());
            sleep[idx] = true;
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int pos = Integer.parseInt(stk.nextToken());
            int add = pos;
            if(sleep[pos]){
                continue;
            }
            while (pos <= arr.length) {
                if (sleep[pos]) {
                    pos += add;
                    continue;
                }
                chk[pos] = true;
                pos += add;
            }
        }

        for (int i = 3; i < n + 3; i++) {
            if (chk[i]) {
                arr[i] = arr[i - 1];
            } else {
                arr[i] = arr[i - 1] + 1;
            }
        }

        while (m-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            bw.write(arr[end] - arr[start-1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}