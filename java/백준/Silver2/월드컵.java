public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] match = new int[15][2];
  static boolean isChk = false;

  public static void main(String[] args) throws IOException {
    int idx = 0;
    for (int i = 0; i <= 4; i++) {
      for (int j = i + 1; j <= 5; j++) {
        match[idx][0] = i;
        match[idx][1] = j;
        idx++;
      }
    }

    for (int i = 0; i < 4; i++) {
      int total = 0;
      int[][] score = new int[6][3];
      StringTokenizer stk = new StringTokenizer(br.readLine());
      for (int j = 0; j < 6; j++) {
        score[j][0] = Integer.parseInt(stk.nextToken());
        score[j][1] = Integer.parseInt(stk.nextToken());
        score[j][2] = Integer.parseInt(stk.nextToken());
        total += score[j][0] + score[j][1] + score[j][2];
      }
      if (total > 30) {
        bw.write("0 ");
      } else {
        isChk = false;
        back(0, score);
        if (isChk) {
          bw.write("1 ");
        } else {
          bw.write("0 ");
        }
      }
    }
    bw.flush();
    bw.close();
  }

  static void back(int cnt, int[][] score) {
    if (cnt == 15 || isChk) {
      isChk = true;
      return;
    }
    int t1 = match[cnt][0];
    int t2 = match[cnt][1];
    //t1이 이기는 경우
    if (score[t1][0] > 0 && score[t2][2] > 0) {
      score[t1][0]--;
      score[t2][2]--;
      back(cnt + 1, score);
      score[t1][0]++;
      score[t2][2]++;
    }
    //비기는 경우
    if (score[t1][1] > 0 && score[t2][1] > 0) {
      score[t1][1]--;
      score[t2][1]--;
      back(cnt + 1, score);
      score[t1][1]++;
      score[t2][1]++;
    }
    //t2가 이기는 경우
    if (score[t1][2] > 0 && score[t2][0] > 0) {
      score[t1][2]--;
      score[t2][0]--;
      back(cnt + 1, score);
      score[t1][2]++;
      score[t2][0]++;
    }
  }
}