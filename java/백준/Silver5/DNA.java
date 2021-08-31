public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stk.nextToken());
    int m = Integer.parseInt(stk.nextToken());

    StringBuilder sb = new StringBuilder();
    String[] arr = new String[n];
    int cnt = 0;

    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine();
    }

    for (int i = 0; i < m; i++) {
      int[] ascii = new int[25];
      for (int j = 0; j < n; j++) {
        int idx = (int) arr[j].charAt(i) - 65;
        ascii[idx] += 1;
      }
      int max = 0;
      char maxChar = 0;
      for (int k = 0; k < ascii.length; k++) {
        if (ascii[k] > max) {
          max = ascii[k];
          maxChar = (char) (k + 65);
        }
      }
      cnt += n - max;
      sb.append(maxChar);
    }
    bw.write(sb + "\n");
    bw.write(cnt + " ");
    bw.flush();
    bw.close();
  }
}