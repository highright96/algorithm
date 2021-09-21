public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static Set<Character> set = new HashSet<>();

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    while (n-- > 0) {
      String s = br.readLine();
      for (int i = 0; i < s.length(); i++) {
        set.add(s.charAt(i));
      }
      int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, m = Integer.parseInt(br.readLine());
      for (char c : set) {
        int l = 0, r = 0, cnt = 0;
        while (r < s.length()) {
          if (s.charAt(r) == c) {
            cnt++;
            if (cnt == m) {
              min = Math.min(min, r - l + 1);
              max = Math.max(max, r - l + 1);
              l++;
              r = l;
              cnt = 0;
            } else if (cnt == 0) {
              l = r;
              r++;
            } else {
              r++;
            }
          } else if (s.charAt(r) != c) {
            if (cnt == 0) {
              r++;
              l++;
            } else if (cnt > 0) {
              r++;
            }
          }
        }
      }
      if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
        bw.write("-1\n");
      } else {
        bw.write(min + " " + max + "\n");
      }
    }
    bw.flush();
    bw.close();
  }
}