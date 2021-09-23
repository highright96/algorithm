public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    Stack<Pos> stack = new Stack<>();
    StringTokenizer stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(stk.nextToken());
      arr[i] = a;
    }

    StringBuilder sb = new StringBuilder();
    stack.push(new Pos(0, arr[0]));
    sb.append(0).append(" ");
    for (int i = 1; i < n; i++) {
      while (true) {
        if (stack.isEmpty()) {
          sb.append(0).append(" ");
          stack.push(new Pos(i, arr[i]));
          break;
        }
        Pos t = stack.peek();
        if (t.val <= arr[i]) {
          stack.pop();
        } else if (t.val > arr[i]) {
          sb.append(t.idx + 1).append(" ");
          stack.push(new Pos(i, arr[i]));
          break;
        }
      }
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  static class Pos {

    int idx;
    int val;

    public Pos(int idx, int val) {
      this.idx = idx;
      this.val = val;
    }
  }
}