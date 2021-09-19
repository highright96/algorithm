public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(stk.nextToken());
    }
    Arrays.sort(arr);
    int s = 0, e = N - 1, ans1 = 0, ans2 = 0;
    int min = Integer.MAX_VALUE;
    while (s < e) {
      int sum = arr[s] + arr[e];
      if (Math.abs(sum) < min) {
        min = Math.abs(sum);
        ans1 = arr[s];
        ans2 = arr[e];
      }
      if (sum < 0) {
        s++;
      } else if (sum > 0) {
        e--;
      } else {
        ans1 = arr[s];
        ans2 = arr[e];
        break;
      }
    }
    bw.write(ans1 + " " + ans2);
    bw.flush();
    bw.close();
  }
}