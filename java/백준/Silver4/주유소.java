public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    long[] city = new long[n];
    long[] road = new long[n - 1];
    StringTokenizer stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n - 1; i++) {
      road[i] = Integer.parseInt(stk.nextToken());
    }
    stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      city[i] = Integer.parseInt(stk.nextToken());
    }

    long min = Long.MAX_VALUE, ans = 0;
    for (int i = 0; i < n - 1; i++) {
      min = Math.min(min, city[i]);
      ans += min * road[i];
    }
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }
}