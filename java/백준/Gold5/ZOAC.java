public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static boolean[] visited;
  private static String s;

  public static void main(String[] args) throws IOException {
    s = br.readLine();
    visited = new boolean[s.length()];
    solution(0, s.length() - 1);
    bw.flush();
    bw.close();
  }

  static void solution(int left, int right) throws IOException {
    if (left > right) {
      return;
    }
    int idx = left;
    for (int i = left; i <= right; i++) {
      if (s.charAt(idx) > s.charAt(i)) {
        idx = i;
      }
    }
    visited[idx] = true;
    for (int i = 0; i < s.length(); i++) {
      if (visited[i]) {
        bw.write(s.charAt(i));
      }
    }
    bw.write("\n");
    solution(idx + 1, right);
    solution(left, idx - 1);
  }
}