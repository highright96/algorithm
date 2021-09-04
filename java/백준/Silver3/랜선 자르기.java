public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(stk.nextToken());
    int n = Integer.parseInt(stk.nextToken());
    int[] arr = new int[k];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < k; i++) {
      int len = Integer.parseInt(br.readLine());
      arr[i] = len;
      max = Math.max(max, len);
    }

    long l = 1, r = max;
    while (l <= r) {
      int total = 0;
      long mid = (l + r) / 2;
      for (int i : arr) {
        total += i / mid;
      }
      if (total >= n) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    bw.write(r + "");
    bw.flush();
    bw.close();
  }
}