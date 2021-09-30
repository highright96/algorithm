public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    String s = br.readLine();
    StringBuilder ans = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= 'A' && c <= 'Z') {
        ans.append(c);
      } else if (c == ')') {
        while (!stack.isEmpty()) {
          if (stack.peek() == '(') {
            stack.pop();
            break;
          }
          ans.append(stack.pop());
        }
      } else if (c == '(') {
        stack.push(c);
      } else {
        while (!stack.isEmpty() && weight(stack.peek()) >= weight(c)) {
          ans.append(stack.pop());
        }
        stack.push(c);
      }
    }
    while (!stack.isEmpty()) {
      ans.append(stack.pop());
    }
    bw.write(ans.toString());
    bw.flush();
    bw.close();
  }

  public static int weight(char c) {
    if (c == '/' || c == '*') {
      return 2;
    } else if (c == '(') {
      return 0;
    }
    return 1;
  }
}