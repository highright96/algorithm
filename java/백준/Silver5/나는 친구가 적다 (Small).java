public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    String a = br.readLine();
    String b = br.readLine();
    String ans = "0";
    a = a.replaceAll("[0-9]", "");
    for (int i = 0; i < a.length(); i++) {
      if (a.startsWith(b, i)) {
        ans = "1";
      }
    }
    bw.write(ans);
    bw.flush();
    bw.close();
  }
}