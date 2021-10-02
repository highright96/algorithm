public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(stk.nextToken());
    int d = Integer.parseInt(stk.nextToken());
    int k = Integer.parseInt(stk.nextToken());
    int c = Integer.parseInt(stk.nextToken());
    int[] visited = new int[3000001];
    int[] table = new int[N];
    for (int i = 0; i < N; i++) {
      table[i] = Integer.parseInt(br.readLine());
    }
    int l = 0, r = k - 1, total = 0, max = Integer.MIN_VALUE;
    for (int i = 0; i < k; i++) {
      int v = table[i];
      if (visited[v] == 0) {
        total++;
      }
      visited[v]++;
    }
    max += visited[c] == 0 ? total + 1 : total;

    while (l != N - 1) {
      visited[table[l]]--;
      total -= visited[table[l]] == 0 ? 1 : 0;
      l++;
      r = (r + 1) % N;
      total += visited[table[r]] == 0 ? 1 : 0;
      visited[table[r]]++;
      if (visited[c] == 0) {
        max = Math.max(max, total + 1);
      } else {
        max = Math.max(max, total);
      }
    }
    bw.write(max + "");
    bw.flush();
    bw.close();
  }
}