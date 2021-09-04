public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stk.nextToken());
    int m = Integer.parseInt(stk.nextToken());
    int[] times = new int[n];
    for (int i = 0; i < n; i++) {
      times[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(times);
    long l = 0, r = (long) times[n - 1] * m, ans = 0;
    while (l <= r) {
      long mid = (l + r) / 2;
      long total = 0;
      for (int i = 0; i < n; i++) {
        total += mid / times[i];
      }
      if (total >= m) {
        ans = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }
}