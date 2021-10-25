public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static List<String> ans = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      back(1, "1", num);
      for (String s : ans) {
        bw.write(s + "\n");
      }
      bw.newLine();
      ans.clear();
    }
    bw.flush();
    bw.close();
  }

  static void back(int cur, String s, int num) {
    if (cur == num) {
      String str = s.replaceAll(" ", "");
      int sum = 0, sign = 1;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c == '+') {
          sum += Integer.parseInt(sb.toString()) * sign;
          sb.delete(0, sb.length());
          sign = 1;
        } else if (c == '-') {
          sum += Integer.parseInt(sb.toString()) * sign;
          sb.delete(0, sb.length());
          sign = -1;
        } else if (i == str.length() - 1) {
          sb.append(c);
          sum += Integer.parseInt(sb.toString()) * sign;
        } else {
          sb.append(c);
        }
      }
      if (sum == 0) {
        ans.add(s);
      }
      return;
    }
    back(cur + 1, s + " " + (cur + 1), num);
    back(cur + 1, s + "+" + (cur + 1), num);
    back(cur + 1, s + "-" + (cur + 1), num);
  }
}