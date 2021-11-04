public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static char[][] arr;
  static String[] signalNumArr = {
      "######...######", "#####", "#.####.#.####.#", "#.#.##.#.######", "###....#..#####",
      "###.##.#.##.###", "######.#.##.###", "#....#....#####", "######.#.######", "###.##.#.######"
  };

  public static void main(String[] args) throws IOException {
    int col = Integer.parseInt(br.readLine()) / 5;
    int row = 5;
    String input = br.readLine();
    arr = new char[row + 1][col + 1];
    createSignalArray(input, col);
    String answer = analyzeSignal(col);
    bw.write(answer);
    bw.flush();
    bw.close();
  }

  public static void createSignalArray(String input, int col) {
    int idx = 0;
    for (int i = 1; i <= 5; i++) {
      for (int j = 1; j <= col; j++) {
        arr[i][j] = input.charAt(idx);
        idx += 1;
      }
    }
  }

  public static String analyzeSignal(int col) {
    StringBuilder answer = new StringBuilder();
    for (int i = 1; i <= col; i++) {
      if (arr[1][i] == '#') {
        StringBuilder sb = new StringBuilder();
        //1일 경우 다음 열은 비어있어야함.
        if (checkNextColIsEmpty(i + 1, col)) {
          answer.append(1);
        } else {
          for (int j = 0; j <= 2; j++) {
            for (int k = 1; k <= 5; k++) {
              sb.append(arr[k][i + j]);
            }
          }
          i += 2;
          int num = findMatchedNumber(sb.toString());
          answer.append(num);
        }
      }
    }
    return answer.toString();
  }

  public static boolean checkNextColIsEmpty(int nextCol, int col) {
    //다음 열이 범위를 넘어서면 1이 마지막 존재함
    if (nextCol <= col) {
      for (int i = 1; i <= 5; i++) {
        if (arr[i][nextCol] == '#') {
          return false;
        }
      }
    }
    return true;
  }

  public static int findMatchedNumber(String s) {
    for (int i = 0; i < signalNumArr.length; i++) {
      if (s.equals(signalNumArr[i])) {
        return i;
      }
    }
    return -1;
  }
}