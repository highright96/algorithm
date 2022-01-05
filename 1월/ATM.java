public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(stk.nextToken()));
        }
        arr.sort(null);
        int prev = 0, ans = 0;
        for (int num : arr) {
            prev += num;
            ans += prev;
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}