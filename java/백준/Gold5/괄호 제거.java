public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static List<Pos> list = new ArrayList<>();
  private static Set<String> ans = new HashSet<>();

  public static void main(String[] args) throws IOException {
    String s = br.readLine();
    char[] chars = s.toCharArray();
    Stack<Pos> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        Pos p = new Pos();
        p.setS(i);
        stack.add(p);
      } else if (s.charAt(i) == ')') {
        Pos p = stack.pop();
        p.setE(i);
        list.add(p);
      }
    }
    remove(0, 0, chars);
    List<String> str = new ArrayList<>(ans);
    str.sort(null);
    for (int i = 1; i<str.size(); i++) {
        bw.write(str.get(i) + "\n");
    }
    bw.flush();
    bw.close();
  }

  public static void remove(int dep, int idx, char[] chars) {
    if (dep == list.size()) {
      ans.add(new String(chars).replaceAll(" ", ""));
      return;
    }
    chars[list.get(idx).s] = ' ';
    chars[list.get(idx).e] = ' ';
    remove(dep + 1, idx + 1, chars);
    chars[list.get(idx).s] = '(';
    chars[list.get(idx).e] = ')';
    remove(dep + 1, idx + 1, chars);
  }

  static class Pos {

    int s;
    int e;

    public Pos() {
    }

    public void setS(int s) {
      this.s = s;
    }

    public void setE(int e) {
      this.e = e;
    }
  }
}