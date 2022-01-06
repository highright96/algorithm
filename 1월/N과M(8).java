public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] arr;
    static List<Integer> num = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[n + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num.add(Integer.parseInt(stk.nextToken()));
        }
        num.sort(null);
        back(0, 0);
        bw.flush();
        bw.close();
    }

    public static void back(int depth, int start) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();
            return;
        }
        for (int i = start; i < n; i++) {
                arr[depth] = num.get(i);
                back(depth + 1, i);
        }
    }
}