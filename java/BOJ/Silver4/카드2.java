public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        solve();
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        int cnt = 0;
        while (deque.size() > 1) {
            cnt += 1;
            if (cnt % 2 == 0) {
                deque.addLast(deque.pollFirst());
            } else {
                deque.pollFirst();
            }
        }
        bw.write(deque.peek() + "\n");
    }
}