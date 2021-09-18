public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N + 1];
    int[] sum = new int[N + 1];
    int t = 0;
    StringTokenizer stk = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(stk.nextToken());
    }
    for (int i = 1; i < N; i++) {
      if (arr[i] > arr[i + 1]) {
        t++;
      }
      sum[i] = t;
    }

    int M = Integer.parseInt(br.readLine());
    while (M-- > 0) {
      stk = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(stk.nextToken());
      int y = Integer.parseInt(stk.nextToken());
      int ans = sum[y - 1] - sum[x - 1];
      bw.write(ans + "\n");
    }
    bw.flush();
    bw.close();
  }
}