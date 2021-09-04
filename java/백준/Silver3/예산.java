public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    long total = 0;
    StringTokenizer stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int money = Integer.parseInt(stk.nextToken());
      arr[i] = money;
      total += money;
      max = Math.max(max, money);
    }
    int m = Integer.parseInt(br.readLine());

    if (total <= m) {
      bw.write(max + "");
    } else {
      long l = 1, r = max, mid = 0;
      while (l <= r) {
        long sum = 0;
        mid = (l + r) / 2;
        for (int i : arr) {
          if (i <= mid) {
            sum += i;
          } else {
            sum += mid;
          }
        }
        if (sum <= m) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      bw.write(r + "");
    }
    bw.flush();
    bw.close();
  }
}