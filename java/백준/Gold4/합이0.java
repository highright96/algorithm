public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<>();
    StringTokenizer stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      list.add(Integer.parseInt(stk.nextToken()));
    }
    list.sort(null);
    int ans = 0;
    for (int i = 0; i < N - 2; i++) {
      int l = i + 1, r = N - 1;
      while (l < r) {
        int sum = list.get(i) + list.get(l) + list.get(r);
        if (sum < 0) {
          l++;
        } else if (sum > 0) {
          r--;
        } else {
          if (list.get(l).equals(list.get(r))) {
            ans += r - l;
          } else {
            int tmp = N-1;
            while (true) {
              if (list.get(r).equals(list.get(tmp))) {
                ans += 1;
              } else if(tmp < r && !list.get(r).equals(list.get(tmp))) {
                break;
              }
              tmp--;
            }
          }
          l++;
        }
      }
    }
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }
}