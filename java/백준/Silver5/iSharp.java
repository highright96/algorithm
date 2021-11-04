/*
방법
1. 주어진 문자열을 공백으로 나눈다.
2. 배열의 첫번째 인덱스는 공통으로 사용되는 변수형이다.
2. 두번째 인덱스부터는 변수형은 꺼꾸로 읽으며 문자열에 더해준다.
*/

public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    String GlobalVariableType = input[0];
    for (int i = 1; i < input.length; i++) {
      StringBuilder answer = new StringBuilder();
      answer.append(GlobalVariableType);
      appendVariableType(input[i], answer);
      bw.write(answer.toString());
    }
    bw.flush();
    bw.close();
  }

  static void appendVariableType(String input, StringBuilder answer) {
    for (int j = input.length() - 2; j >= 0; j--) {
      char c = input.charAt(j);
      if (c == ']') {
        answer.append("[]");
        j--;
      } else if (c == '&' || c == '*') {
        answer.append(c);
      } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
        answer.append(" ");
        appendVariableName(input, j, answer);
        answer.append(";\n");
        break;
      }
    }
  }

  static void appendVariableName(String input, int end, StringBuilder answer) {
    for (int k = 0; k <= end; k++) {
      answer.append(input.charAt(k));
    }
  }
}