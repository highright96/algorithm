public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] dy = {1, 0, -1, 0}; //상 우 하 좌
  static int[] dx = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      bw.write(solution(s) + "\n");
    }
    bw.flush();
    bw.close();
  }

  static int solution(String s) {
    int dir = 0, y = 0, x = 0;
    int xmi = 0, ymi = 0, xma = 0, yma = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'F') {
        y += dy[dir];
        x += dx[dir];
      } else if (c == 'B') {
        y -= dy[dir];
        x -= dx[dir];
      } else if (c == 'L') {
        dir = (dir + 3) % 4;
      } else if (c == 'R') {
        dir = (dir + 1) % 4;
      }
      xmi = Math.min(xmi, x);
      ymi = Math.min(ymi, y);
      xma = Math.max(xma, x);
      yma = Math.max(yma, y);
    }
    return (xma - xmi) * (yma - ymi);
  }
}