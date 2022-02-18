/*
백준 골드4
문제 유형 : 이분탐색
걸린 시간 : 40분
*/
public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        long n = Long.parseLong(stk.nextToken());
        long m = Long.parseLong(stk.nextToken());
        String ans = "NO";
        long l = 0, r = n;
        while (l <= r) {
            long row = (l + r) / 2, col = n - row;
            long cnt = (row + 1) * (col + 1);
            if (cnt > m) {
                l = row + 1;
            } else if (cnt < m) {
                r = row - 1;
            } else {
                ans = "YES";
                break;
            }
        }
        bw.write(ans);
        bw.flush();
        bw.close();
    }
}