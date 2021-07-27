public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            solve(m);
        }
        bw.flush();
        bw.close();
    }

    public static void solve(int m) throws IOException {
        if (m == 0) {
            if (pq.size() == 0) {
                bw.write("0\n");
            } else {
                bw.write(pq.poll() + "\n");
            }
        }else {
            pq.add(m);
        }
    }
}