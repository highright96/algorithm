public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    Set<Integer> set = new HashSet<>();
    int n = Integer.parseInt(br.readLine());
    StringTokenizer stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      set.add(Integer.parseInt(stk.nextToken()));
    }

    int m = Integer.parseInt(br.readLine());
    stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      if (set.contains(Integer.parseInt(stk.nextToken()))) {
        bw.write("1 ");
      } else {
        bw.write("0 ");
      }
    }
    bw.flush();
    bw.close();
  }
}