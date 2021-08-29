public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    int ans = 0;
    while (true) {
      if (n % 5 == 0) {
        ans += n / 5;
        bw.write(ans + " ");
        break;
      }
      n -= 2;
      ans += 1;
      if (n < 0) {
        bw.write("-1");
        break;
      }
    }
    bw.flush();
    bw.close();
  }
}