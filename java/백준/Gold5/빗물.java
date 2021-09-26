public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int H = Integer.parseInt(stk.nextToken());
    int W = Integer.parseInt(stk.nextToken());
    int[] arr = new int[W];
    stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < W; i++) {
      arr[i] = Integer.parseInt(stk.nextToken());
    }
    int ans = 0;
    for (int i = 1; i < W - 1; i++) {
      int l = Integer.MIN_VALUE, r = Integer.MIN_VALUE;
      for (int j = i; j >= 0; j--) {
        l = Math.max(l, arr[j]);
      }
      for (int j = i; j < W; j++) {
        r = Math.max(r, arr[j]);
      }
      if (l > arr[i] && r > arr[i]) {
        int min = Math.min(l, r);
        ans += min - arr[i];
      }
    }
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }
}