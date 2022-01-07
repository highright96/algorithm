public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[] arr = new int[n];
        stk = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(stk.nextToken());
            max = Math.max(max, h);
            arr[i] = h;
        }

        int l = 0, r = max;
        while (l <= r) {
            long sum = 0;
            int mid = (r + l) / 2;
            for (int tree : arr) {
                sum += tree > mid ? tree - mid : 0;
            }
            if (sum >= m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        bw.write(r + "\n");
        bw.flush();
        bw.close();
    }
}