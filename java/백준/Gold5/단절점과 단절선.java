public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
    }
    for (int i = 1; i < n; i++) {
      StringTokenizer stk = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(stk.nextToken());
      int b = Integer.parseInt(stk.nextToken());
      list.get(a).add(b);
      list.get(b).add(a);
    }
    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      StringTokenizer stk = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(stk.nextToken());
      int b = Integer.parseInt(stk.nextToken());
      if (a == 1) {
        String ans = list.get(b).size() > 1 ? "yes" : "no";
        bw.write(ans + "\n");
      } else {
        bw.write("yes\n");
      }
    }
    bw.flush();
    bw.close();
  }
}