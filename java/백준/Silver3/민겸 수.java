public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    String s = br.readLine();
    int m = 0;
    StringBuilder max = new StringBuilder();
    StringBuilder min = new StringBuilder();
    //max
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'M') {
        m++;
        if (i == s.length() - 1) {
          max.append("1".repeat(Math.max(0, m)));
        }
      } else if (s.charAt(i) == 'K') {
        max.append(5);
        max.append("0".repeat(Math.max(0, m)));
        m = 0;
      }
    }
    //min
    m = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'M') {
        m++;
        if (i == s.length() - 1) {
          min.append(1);
          min.append("0".repeat(Math.max(0, m - 1)));
        }
      } else if (s.charAt(i) == 'K') {
        if (m > 0) {
          min.append(1);
          min.append("0".repeat(m - 1));
        }
        min.append(5);
        m = 0;
      }
    }
    bw.write(max + "\n");
    bw.write(min.toString());
    bw.flush();
    bw.close();
  }
}