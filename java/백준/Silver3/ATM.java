public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stk.nextToken());
    int[] arr = new int[n];
    stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(stk.nextToken());
    }
    Arrays.sort(arr);
    int sum = 0, prev = 0;
    for (int i : arr) {
      prev += i;
      sum += prev;
    }
    bw.write(sum + "");
    bw.flush();
    bw.close();
  }
}