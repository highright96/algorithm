public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static String a;
    private static int b;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a = stk.nextToken();
            if (a.equals("push")) {
                b = Integer.parseInt(stk.nextToken());
            }
            solve();
        }
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        if (a.equals("push")) {
            stack.add(b);
        } else if (a.equals("top")) {
            if (stack.isEmpty()) {
                bw.write(-1 + "\n");
            } else {
                bw.write(stack.peek() + "\n");
            }
        } else if (a.equals("pop")) {
            if (stack.isEmpty()) {
                bw.write(-1 + "\n");
            } else {
                bw.write(stack.pop() + "\n");
            }
        } else if (a.equals("size")) {
            bw.write(stack.size() + "\n");
        } else if (a.equals("empty")) {
            if (stack.isEmpty()) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }
    }
}