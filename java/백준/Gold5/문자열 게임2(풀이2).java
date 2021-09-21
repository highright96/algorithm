public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static List<Integer>[] list = new ArrayList[26];

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    while (n-- > 0) {
      for (int i = 0; i < 26; i++) {
        list[i] = new ArrayList<>();
      }
      String s = br.readLine();
      int m = Integer.parseInt(br.readLine());
      for (int i = 0; i < s.length(); i++) {
        list[s.charAt(i) - 'a'].add(i);
      }
      int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
      for (int i = 0; i < list.length; i++) {
        int l = 0;
        int r = m - 1;
        while (r < list[i].size()) {
          min = Math.min(min, list[i].get(r) - list[i].get(l) + 1);
          max = Math.max(max, list[i].get(r) - list[i].get(l) + 1);
          l++;
          r++;
        }
      }
      if (min == Integer.MAX_VALUE) {
        bw.write("-1\n");
      } else {
        bw.write(min + " " + max + "\n");
      }
    }
    bw.flush();
    bw.close();
  }
}