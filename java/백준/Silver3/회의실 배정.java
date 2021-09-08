public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stk.nextToken());
    List<Time> times = new ArrayList<>();
    while (n-- > 0) {
      stk = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(stk.nextToken());
      int e = Integer.parseInt(stk.nextToken());
      times.add(new Time(s, e));
    }
    times.sort(new Comparator<Time>() {
      @Override
      public int compare(Time o1, Time o2) {
        if (o1.e == o2.e) {
          return o1.s - o2.s;
        }
        return o1.e - o2.e;
      }
    });
    int ans = 1;
    int prev = times.get(0).e;
    for (int i = 1; i < times.size(); i++) {
      if (prev <= times.get(i).s) {
        ans += 1;
        prev = times.get(i).e;
      }
    }
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }

  public static class Time {

    int s;
    int e;

    public Time(int s, int e) {
      this.s = s;
      this.e = e;
    }
  }
}