/*
백준 골드4
문제 유형 : 이분탐색
걸린 시간 : 50분
*/
public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] homes;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        homes = new int[n];

        for (int i = 0; i < n; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);

        int l = 1, r = homes[n - 1] - homes[0];
        while (l <= r) {
            int mid = (l + r) / 2;
            if(install(mid) >= m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        bw.write(l - 1 + "");
        bw.flush();
        bw.close();
    }

    static int install(int mid) {
        int cnt = 1;
        int prevHome = homes[0];

        for (int i = 1; i < n; i++) {
            int diff = homes[i] - prevHome;
            if(diff >= mid) {
                cnt++;
                prevHome = homes[i];
            }
        }
        return cnt;
    }
}