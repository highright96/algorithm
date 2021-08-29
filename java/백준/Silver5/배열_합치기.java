public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[] a, b;
  private static int n, m;

  public static void main(String[] args) throws IOException {
    StringTokenizer stk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(stk.nextToken());
    m = Integer.parseInt(stk.nextToken());

    a = new int[n];
    b = new int[m];

    stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(stk.nextToken());
    }

    stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      b[i] = Integer.parseInt(stk.nextToken());
    }

    int ap = 0, bp = 0;
    while (ap < n && bp < m) {
      if (a[ap] < b[bp]) {
        bw.write(a[ap] + " ");
        ap += 1;
      } else {
        bw.write(b[bp] + " ");
        bp += 1;
      }
    }
    while(ap<n) {
      bw.write(a[ap++] + " ");
    }
    while(bp<m) {
      bw.write(b[bp++] + " ");
    }
    bw.flush();
    bw.close();
  }
}