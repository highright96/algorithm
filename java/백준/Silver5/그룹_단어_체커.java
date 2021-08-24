public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, ans = 0;
    private static String s;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            s = br.readLine();
            solution();
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    static void solution() {
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (!set.contains(s.charAt(i))) {
                    set.add(s.charAt(i));
                } else {
                    return;
                }
            }
        }
        ans += 1;
    }
}