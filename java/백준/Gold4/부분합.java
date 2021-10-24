public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(stk.nextToken());
    int S = Integer.parseInt(stk.nextToken());

    int[] arr = new int[N];
    stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(stk.nextToken());
    }

    int min = Integer.MAX_VALUE, sum = 0, l = 0, r = 0;
    while (true) {
      if (sum >= S) {
        min = Math.min(min, r - l);
        sum -= arr[l];
        l++;
      } else if(r == N) {
        break;
      } else {
        sum += arr[r];
        r++;
      }
    }
    int ans = min == Integer.MAX_VALUE ? 0 : min;
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }
}