public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int n, m, cnt = 0;
  private static int[] num;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(stk.nextToken());
    m = Integer.parseInt(stk.nextToken());
    num = new int[n];
    stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(stk.nextToken());
    }
    solution(0, 0);
    if (m == 0) {
      cnt--;
    }
    bw.write(cnt + "");
    bw.flush();
    bw.close();
  }

  public static void solution(int k, int sum) {
    if (k == n) {
      if (sum == m) {
        cnt++;
      }
      return;
    }
    solution(k + 1, sum);
    solution(k + 1, sum + num[k]);
  }
}