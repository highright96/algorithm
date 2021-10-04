public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static String S;
  private static boolean isChk = false;

  public static void main(String[] args) throws IOException {
    S = br.readLine();
    String T = br.readLine();
    solutions(T);
    String ans = isChk ? "1" : "0";
    bw.write(ans);
    bw.flush();
    bw.close();
  }

  static void solutions(String T) {
    if (T.length() == S.length()) {
      if (T.equals(S)) {
        isChk = true;
      }
      return;
    }

    if (T.charAt(T.length() - 1) == 'A') {
      solutions(T.substring(0, T.length() - 1));
    }

    if (T.charAt(0) == 'B') {
      StringBuilder sb = new StringBuilder(T);
      sb.deleteCharAt(0).reverse();
      solutions(sb.toString());
    }
  }
}