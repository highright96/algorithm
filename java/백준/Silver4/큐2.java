public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static String a;
    private static int b;
    private static Deque<Integer> queue = new LinkedList<>();

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
            queue.add(b);
        } else if (a.equals("front")) {
            if (queue.isEmpty()) {
                bw.write(-1 + "\n");
            } else {
                bw.write(queue.peek() + "\n");
            }
        } else if (a.equals("back")) {
            if (queue.isEmpty()) {
                bw.write(-1 + "\n");
            } else {
                bw.write(queue.peekLast() + "\n");
            }
        } else if (a.equals("pop")) {
            if (queue.isEmpty()) {
                bw.write(-1 + "\n");
            } else {
                bw.write(queue.poll() + "\n");
            }
        } else if (a.equals("size")) {
            bw.write(queue.size() + "\n");
        } else if (a.equals("empty")) {
            if (queue.isEmpty()) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }
    }
}