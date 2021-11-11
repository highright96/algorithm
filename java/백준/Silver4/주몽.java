public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<>();
    StringTokenizer stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(stk.nextToken()));
    }
    list.sort(null);
    int l = 0, r = list.size() - 1, ans = 0;
    while (l < r) {
      if (list.get(l) + list.get(r) < m) {
        l++;
      } else {
        if (list.get(l) + list.get(r) == m) {
          ans++;
        }
        r--;
      }
    }
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }
}