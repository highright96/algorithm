public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr = new int[31];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 28; i++) {
            int idx = Integer.parseInt(br.readLine());
            arr[idx] = 1;
        }
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        for (int i = 1; i < 31; i++) {
            if (arr[i] != 1) {
                bw.write(i + "\n");
            }
        }
    }
}