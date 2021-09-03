public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[] arr, len;
  private static int n, k;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(stk.nextToken());
    k = Integer.parseInt(stk.nextToken());
    stk = new StringTokenizer(br.readLine());
    arr = new int[200005];
    len = new int[100001];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(stk.nextToken());
    }

    int s = 0, e = 0, max = 0;
    len[arr[s]] += 1;
    while (e < n) {
      if (len[arr[e]] > k) {
        len[arr[s]] -= 1;
        s += 1;
      } else {
        max = Math.max(e - s + 1, max);
        e += 1;
        len[arr[e]] += 1;
      }
    }
    bw.write(max + " ");
    bw.flush();
    bw.close();
  }
}