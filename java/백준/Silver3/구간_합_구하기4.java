public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[] arr, sum;
  private static int n, m;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(stk.nextToken());
    m = Integer.parseInt(stk.nextToken());

    arr = new int[n+1];
    sum = new int[n+1];

    stk = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(stk.nextToken());
      sum[i] = sum[i-1] + arr[i];
    }

    for (int i = 0; i < m; i++) {
      stk = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(stk.nextToken());
      int e = Integer.parseInt(stk.nextToken());
      bw.write(sum[e] - sum[s-1]  + "\n");
    }
    bw.flush();
    bw.close();
  }
}