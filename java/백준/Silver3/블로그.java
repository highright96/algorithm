public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stk.nextToken());
    int x = Integer.parseInt(stk.nextToken());

    int[] arr = new int[n + 1];
    int[] sum = new int[n + 1];

    stk = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(stk.nextToken());
      sum[i] = sum[i - 1] + arr[i];
    }

    int s = 1, e = x, max = Integer.MIN_VALUE, cnt = 0;
    while (e <= n) {
      int v = sum[e] - sum[s - 1];
      if (v > max) {
        max = v;
        cnt = 1;
      } else if (v == max) {
        cnt += 1;
      }
      s += 1;
      e += 1;
    }
    if (max == 0) {
      bw.write("SAD");
    } else {
      bw.write(max + "\n");
      bw.write(cnt + "\n");
    }
    bw.flush();
    bw.close();
  }
}