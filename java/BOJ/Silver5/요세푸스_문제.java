public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int a, b;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        StringTokenizer stk = new StringTokenizer(br.readLine());
        a = Integer.parseInt(stk.nextToken());
        b = Integer.parseInt(stk.nextToken());
        solve();

        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        for (int i = 0; i < a; i++) {
            queue.add(i + 1);
        }
        int cnt = 0;
        bw.write("<");
        while (!queue.isEmpty()) {
            cnt += 1;
            if (cnt % b == 0) {
                bw.write(valueOf(queue.poll()));
            } else {
                queue.add(queue.peek());
                queue.remove();
            }
        }
        bw.write(">");
    }
}