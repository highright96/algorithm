public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Queue<Node> q = new LinkedList<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    private static int a, b, n, cnt;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            a = Integer.parseInt(str.nextToken());
            b = Integer.parseInt(str.nextToken());

            str = new StringTokenizer(br.readLine());
            for (int i = 0; i < a; i++) {
                boolean isAns = i == b;
                int c = Integer.parseInt(str.nextToken());
                q.add(new Node(isAns, c));
                pq.add(c);
            }
            solve();
        }
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        cnt = 0;
        while (!q.isEmpty()) {
            for (int j = 0; j < q.size(); j++) {
                if (q.peek().priority.equals(pq.peek())) {
                    cnt += 1;
                    if (q.peek().isAns) {
                        bw.write(cnt + "\n");
                        return;
                    }
                    q.poll();
                    pq.poll();
                } else {
                    q.add(q.remove());
                }
            }
        }
    }

    static class Node {

        boolean isAns;
        Integer priority;

        public Node(boolean isAns, int priority) {
            this.isAns = isAns;
            this.priority = priority;
        }
    }
}