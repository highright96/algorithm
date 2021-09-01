public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    Set<String> set = new HashSet<>();
    PriorityQueue<String> q = new PriorityQueue<>();
    int n = Integer.parseInt(stk.nextToken());
    int m = Integer.parseInt(stk.nextToken());
    while (n-- > 0) {
      set.add(br.readLine());
    }
    while (m-- > 0) {
      String s = br.readLine();
      if (set.contains(s)) {
        q.add(s);
      }
    }
    bw.write(q.size() + "\n");
    while (!q.isEmpty()) {
      bw.write(q.poll() + "\n");
    }
    bw.flush();
    bw.close();
  }
}