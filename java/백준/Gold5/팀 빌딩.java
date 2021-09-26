public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(stk.nextToken());
    }

    int s = 0, e = n - 1, max = Integer.MIN_VALUE;
    while (s <= e) {
      int v = (e - s - 1) * Math.min(arr[s], arr[e]);
      max = Math.max(max, v);
      if (arr[s] < arr[e]) {
        s++;
      } else {
        e--;
      }
    }
    bw.write(max + "");
    bw.flush();
    bw.close();
  }
}