public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int ans = 0;
    int n = Integer.parseInt(br.readLine());
    int[] height = new int[367];
    for (int i = 0; i < n; i++) {
      StringTokenizer stk = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(stk.nextToken());
      int end = Integer.parseInt(stk.nextToken());
      for (int j = start; j <= end; j++) {
        height[j] += 1;
      }
    }
    int g = 0, s = 0;
    for (int i = 1; i < 367; i++) {
      if (height[i] != 0) {
        g += 1;
        s = Math.max(s, height[i]);
      } else if (height[i] == 0) {
        ans += g * s;
        g = 0;
        s = 0;
      }
    }
    bw.write(String.valueOf(ans));
    bw.flush();
    bw.close();
  }
}