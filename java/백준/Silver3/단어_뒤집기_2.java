public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String str;
    private static Stack<Character> stack = new Stack<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        str = br.readLine();
        solution();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solution() {
        boolean chk = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '<') {
                pop();
                sb.append(c);
                chk = true;
            } else if (c == '>') {
                sb.append(c);
                chk = false;
            } else if (chk) {
                sb.append(c);
            } else if (c == ' ') {
                pop();
                sb.append(c);
            } else if (i < str.length() - 1) {
                stack.add(c);
            } else {
                stack.add(c);
                pop();
            }
        }
    }

    static void pop() {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}