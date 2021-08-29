public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    String s = br.readLine();
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '.') {
        if (cnt % 2 == 0) {
          fill(cnt);
          cnt = 0;
        } else {
          System.out.println(-1);
          return;
        }

        sb.append(".");
      } else {
        cnt++;
      }
    }
    if (cnt % 2 == 0) {
      fill(cnt);
    } else {
      System.out.println(-1);
      return;
    }
    System.out.println(sb);
  }

  static public void fill(int cnt) {
    int length = cnt / 4;
    for (int i = 0; i < length; i++) {
      sb.append("AAAA");
    }
    length = cnt % 4;
    if (length != 0) {
      sb.append("BB");
    }
  }
}