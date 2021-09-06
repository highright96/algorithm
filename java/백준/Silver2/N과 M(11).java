public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int n, m;
  private static int[] arr, cnt;
  private static List<Integer> num = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(stk.nextToken());
    m = Integer.parseInt(stk.nextToken());
    arr = new int[m];
    cnt = new int[10001];
    stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int v = Integer.parseInt(stk.nextToken());
      if (!num.contains(v)) {
        num.add(v);
      }
      cnt[v]++;
    }
    num.sort(null);
    solution(0);
    bw.flush();
    bw.close();
  }

  public static void solution(int k) throws IOException {
    if (k == m) {
      for (int i : arr) {
        bw.write(i + " ");
      }
      bw.write("\n");
      return;
    }
    for (int r : num) {
      arr[k] = r;
      cnt[r]--;
      solution(k + 1);
      cnt[r]++;
    }
  }
}