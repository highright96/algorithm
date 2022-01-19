/*
백준 실버 1
문제 유형 : 그리디, 누적합
걸린 시간 : 1시간
*/
public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] road = new int[n + 1];
        int[] sum = new int[n + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            road[i] = Integer.parseInt(stk.nextToken());
            sum[i] = sum[i - 1] + road[i];
        }

        long answer = 0;
        for (int i = 2; i <= n - 1; i++) {
            answer = Math.max(answer, getTotalHoney(road, sum, 1, n, i));
            answer = Math.max(answer, getTotalHoney(road, sum, 1, i, n));
            answer = Math.max(answer, getTotalHoney(road, sum, n, i, 1));
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static long getTotalHoney(int[] road, int[] sum, int bee1, int bee2, int honey) {
        if (honey > bee1 && honey < bee2) {
            return sum[honey] - sum[bee1] + sum[bee2 - 1] - sum[honey - 1];
        }
        if (honey > bee1 && honey > bee2) {
            return sum[honey] - sum[bee1] - road[bee2] + sum[honey] - sum[bee2];
        }
        return sum[bee1 - 1] - sum[honey - 1] - road[bee2] + sum[bee2 - 1] - sum[honey - 1];
    }
}