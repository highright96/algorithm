/*
백준 실버 1
문제 유형 : DP
걸린 시간 : 1시간
*/
public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        long[] pow = new long[n + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        pow[1] = 0;
        pow[2] = (long) 1 + Math.abs(arr[1] - arr[2]);
        for (int i = 3; i <= n; i++) {
            pow[i] = Long.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                long power = (long) (i - j) * (1 + Math.abs(arr[j] - arr[i]));
                power = Math.max(power, pow[j]);
                pow[i] = Math.min(power, pow[i]);
            }
        }
        bw.write(pow[n] + "\n");
        bw.flush();
        bw.close();
    }
}