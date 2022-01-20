/*
백준 실버 1
문제 유형 : 백트래킹
걸린 시간 : 2시간
*/
public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(stk.nextToken());
            w[i] = Integer.parseInt(stk.nextToken());
        }
        breakEgg(d, w, 0, 0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static void breakEgg(int[] d, int[] w, int cur, int cnt) {
        if (cur >= d.length) {
            answer = Math.max(answer, cnt);
            return;
        }

        if (d[cur] <= 0 || cnt == d.length - 1) {
            breakEgg(d, w, cur + 1, cnt);
            return;
        }

        for (int i = 0; i < d.length; i++) {
            if (i == cur || d[i] <= 0) {
                continue;
            }

            d[cur] -= w[i];
            d[i] -= w[cur];
            int plusCnt = 0;
            plusCnt += d[cur] <= 0 ? 1 : 0;
            plusCnt += d[i] <= 0 ? 1 : 0;
            breakEgg(d, w, cur + 1, cnt + plusCnt);
            d[cur] += w[i];
            d[i] += w[cur];
        }
    }
}