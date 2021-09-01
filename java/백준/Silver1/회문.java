public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static String s, ans;
  private static boolean flag;

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    while (n-- > 0) {
      s = br.readLine();
      flag = false;
      boolean isChk = solution(0, s.length() - 1);
      if (isChk) {
        ans = flag ? "1" : "0";
      } else {
        ans = "2";
      }
      bw.write(ans + "\n");
    }
    bw.flush();
    bw.close();
  }

  public static boolean solution(int start, int end) {
    while (start <= end) {
      if (s.charAt(start) == s.charAt(end)) {
        start += 1;
        end -= 1;
      } else {
        if (!flag) {
          flag = true;
          return solution(start + 1, end) || solution(start, end - 1);
        } else {
          return false;
        }
      }
    }
    return true;
  }
}