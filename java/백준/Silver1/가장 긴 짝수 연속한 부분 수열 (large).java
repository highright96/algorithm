public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[] arr;
  private static int n, k;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(stk.nextToken());
    k = Integer.parseInt(stk.nextToken());
    stk = new StringTokenizer(br.readLine());
    arr = new int[1000001];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(stk.nextToken());
    }

    int cnt = 0, max = 0, ans = 0, s = 0, e = 0;
    while (s <= e && e < n) {
      if (cnt <= k) {
        if (arr[e] % 2 != 0) {
          cnt += 1;
        }
        max = Math.max(max, e - s + 1 - cnt);
        e += 1;
      } else {
        if (arr[s] % 2 != 0) {
          cnt -= 1;
        }
        s += 1;
      }
    }
    ans = max;
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }
}