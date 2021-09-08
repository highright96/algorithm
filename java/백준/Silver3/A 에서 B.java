public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int ans = 0;
    long n = Long.parseLong(stk.nextToken());
    long m = Long.parseLong(stk.nextToken());
    while (m != n) {
      if (m < n) {
        ans = -1;
        break;
      }
      if (m % 10 == 1) {
        m = m / 10;
      } else if (m % 2 == 0) {
        m /= 2;
      } else {
        ans = -1;
        break;
      }
      ans++;

    }
    ans += ans == -1 ? 0 : 1;
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }
}