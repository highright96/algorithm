public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String s;
    private static int ans = 0;


    public static void main(String[] args) throws IOException {
        s = br.readLine();
        s = br.readLine();
        solution();
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    static void solution() {
        for (int i = 0; i < s.length(); i++) {
            ans += s.charAt(i) - '0';
        }
    }
}