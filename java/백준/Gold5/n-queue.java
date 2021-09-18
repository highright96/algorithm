public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int N, ans = 0;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    solution(0);
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }

  public static void solution(int y) {
    if (y == N) {
      ans++;
      return;
    }
    for (int i = 0; i < N; i++) {
      arr[y] = i;
      if (check(y)) {
        solution(y + 1);
      }
    }
  }

  public static boolean check(int y) {
    for (int i = 0; i < y; i++) {
      if (arr[y] == arr[i]) {
        return false;
      } else if (Math.abs(y - i) == Math.abs(arr[y] - arr[i])) {
        return false;
      }
    }
    return true;
  }
}