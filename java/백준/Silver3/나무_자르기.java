public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[] arr;
  private static int n, m;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(stk.nextToken());
    m = Integer.parseInt(stk.nextToken());
    arr = new int[n];
    stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(stk.nextToken());
    }

    Arrays.sort(arr);
    int end = arr[n - 1];
    int start = 0;
    while (start <= end) {
      long sum = 0;
      int mid = (end + start) / 2;
      for (int v : arr) {
        int r = v - mid;
        if (r > 0) {
          sum += r;
        }
      }

      if (sum >= m) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    bw.write(end + " ");
    bw.flush();
    bw.close();
  }
}