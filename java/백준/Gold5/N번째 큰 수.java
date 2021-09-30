public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    long ans = 0;
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < n; i++) {
      StringTokenizer stk = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        long num = Integer.parseInt(stk.nextToken());
        queue.add(num);
      }
    }
    for (int i = 0; i < n; i++) {
      ans = queue.poll();
    }
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }
}