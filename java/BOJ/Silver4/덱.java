public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static String a;
    private static int b;
    private static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a = stk.nextToken();
            if (a.equals("push_back") || a.equals("push_front")) {
                b = Integer.parseInt(stk.nextToken());
            }
            solve();
        }
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {

        switch (a) {
            case "push_front": {
                deque.addFirst(b);
                break;
            }
            case "push_back": {
                deque.addLast(b);
                break;
            }
            case "pop_front": {
                if (deque.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(deque.pollFirst() + "\n");
                }
                break;
            }
            case "pop_back": {
                if (deque.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(deque.pollLast() + "\n");
                }
                break;
            }
            case "size": {
                bw.write(deque.size() + "\n");
                break;
            }
            case "empty": {
                if (deque.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
                break;
            }
            case "front": {
                if (deque.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(deque.peekFirst() + "\n");
                }
                break;
            }
            case "back": {
                if (deque.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(deque.peekLast() + "\n");
                }
                break;
            }
        }
    }
}