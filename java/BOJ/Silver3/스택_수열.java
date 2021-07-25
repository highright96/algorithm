public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static List<Integer> arr = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        solve();
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            stack.add(i);
            sb.append("+\n");
            while (!stack.isEmpty() && stack.peek().equals(arr.get(index))) {
                index += 1;
                stack.pop();
                sb.append("-\n");
            }
        }
        if (!stack.isEmpty()) {
            bw.write("NO");
        } else {
            bw.write(valueOf(sb));
        }
    }
}