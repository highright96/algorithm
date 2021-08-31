public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(stk.nextToken());
    int b = Integer.parseInt(stk.nextToken());
    int c = Integer.parseInt(stk.nextToken());
    int d = Integer.parseInt(stk.nextToken());
    int e = Integer.parseInt(stk.nextToken());
    int f = Integer.parseInt(stk.nextToken());
    int x = (c * e - b * f) / (a * e - b * d);
    int y = (c * d - a * f) / (b * d - a * e);
    bw.write(x + " " + y);
    bw.flush();
    bw.close();
  }
}