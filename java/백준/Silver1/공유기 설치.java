public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stk.nextToken());
    int c = Integer.parseInt(stk.nextToken());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    int l = 1, r = arr[n - 1] - arr[0], ans = 0;
    while (l <= r) {
      int mid = (r + l) / 2;
      int start = arr[0];
      int cnt = 1;
      for (int i = 0; i < n; i++) {
        int d = arr[i] - start;
        if (d >= mid) {
          cnt += 1;
          start = arr[i];
        }
      }
      if (cnt >= c) {
        ans = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }
}