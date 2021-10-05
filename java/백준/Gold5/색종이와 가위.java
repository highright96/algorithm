public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    long n = Long.parseLong(stk.nextToken());
    long k = Long.parseLong(stk.nextToken());
    long l = 0, r = n;
    boolean isChk = false;
    while (l <= r) {
      long mid = (l + r) / 2;
      long c = (mid + 1) * (n - mid + 1);
      if (c > k) {
        l = mid + 1;
      } else if (c < k) {
        r = mid - 1;
      } else if (c == k) {
        isChk = true;
        break;
      }
    }
    String ans = isChk ? "YES" : "NO";
    bw.write(ans);
    bw.flush();
    bw.close();
  }
}