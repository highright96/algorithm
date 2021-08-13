public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static String str;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        str = stk.nextToken();
        solve();
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        int cnt1 = 0;
        int cnt2 = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(0);
                cnt1 += 1;
            } else if (str.charAt(i) == '[') {
                stack.push(1);
                cnt2 += 1;
            } else if (str.charAt(i) == ')') {
                if (cnt1 == 0) {
                    bw.write("0");
                    return;
                }
                if (stack.peek() == 0) {
                    stack.pop();
                    stack.push(2);
                } else {
                    int tmp = 0;
                    while (stack.peek() != 0) {
                        tmp += stack.pop();
                        if (stack.size() == 0) {
                            bw.write("0");
                            return;
                        }
                    }
                    stack.pop();
                    tmp = tmp * 2;
                    stack.add(tmp);
                }
                cnt1 -= 1;
            } else if (str.charAt(i) == ']') {
                if (cnt2 == 0) {
                    bw.write("0");
                    return;
                }
                if (stack.peek() == 1) {
                    stack.pop();
                    stack.push(3);
                } else {
                    int tmp = 0;
                    while (stack.peek() != 1) {
                        tmp += stack.pop();
                        if (stack.size() == 0) {
                            bw.write("0");
                            return;
                        }
                    }
                    stack.pop();
                    tmp = tmp * 3;
                    stack.add(tmp);
                }
                cnt2 -= 1;
            }
        }
        if (cnt1 != 0 || cnt2 != 0) {
            bw.write("0");
            return;
        }
        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        bw.write(total + "\n");
    }
}