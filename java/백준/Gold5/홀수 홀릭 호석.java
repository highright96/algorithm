public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    int k = String.valueOf(n).length();
    solution(n, k, 0);
    bw.write(min + " " + max);
    bw.flush();
    bw.close();
  }

  public static void solution(int n, int k, int cnt) {
    String s = String.valueOf(n);
    for (int i = 0; i < s.length(); i++) {
      int num = s.charAt(i) - '0';
      if (num % 2 != 0) {
        cnt++;
      }
    }
    if (k == 1) {
      min = Math.min(min, cnt);
      max = Math.max(max, cnt);
      return;
    }
    if (k >= 3) {
      for (int i = 0; i < k - 2; i++) {
        for (int j = i + 1; j < k - 1; j++) {
          int sum = Integer.parseInt(s.substring(0, i + 1)) +
              Integer.parseInt(s.substring(i + 1, j + 1)) + Integer.parseInt(s.substring(j + 1, k));
          solution(sum, String.valueOf(sum).length(), cnt);
        }
      }
    } else if (k == 2) {
      for (int i = 0; i < k - 1; i++) {
        int sum = Integer.parseInt(s.substring(0, i + 1)) + Integer.parseInt(s.substring(i + 1, k));
        solution(sum, String.valueOf(sum).length(), cnt);
      }
    }
  }
}