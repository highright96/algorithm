public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static Deque<Node> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            deque.addLast(new Node(i + 1, Integer.parseInt(str.nextToken())));
        }
        solve();
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        while (!deque.isEmpty()) {
            Node d = deque.pollFirst();
            bw.write(d.index + " ");
            if (d.val < 0 && !deque.isEmpty()) {
                for (int i = 0; i < abs(d.val); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            } else if (d.val > 0 && !deque.isEmpty()) {
                for (int i = 0; i < d.val - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            }
        }
    }

    static class Node {

        int index, val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}