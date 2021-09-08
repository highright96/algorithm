public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int ans = 0;
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stk.nextToken());
    int[] arr = new int[n + 1];
    int[] sum = new int[n + 1];
    stk = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(stk.nextToken());
      sum[i] += sum[i - 1] + arr[i];
    }

    //벌벌통
    for (int i = 2; i < n; i++) {
      int total = sum[n] - arr[1] - arr[i] + sum[n] - sum[i];
      ans = Math.max(total, ans);
    }
    //통벌벌
    for (int i = 2; i < n; i++) {
      int total = sum[n] - arr[n] - arr[i] + sum[i] - arr[i];
      ans = Math.max(total, ans);
    }
    //벌통벌
    for (int i = 2; i < n; i++) {
      int total = sum[n] - sum[i - 1] - arr[n] + sum[i] - arr[1];
      ans = Math.max(total, ans);
    }
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }