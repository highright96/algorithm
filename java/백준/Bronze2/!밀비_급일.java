public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String s;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true) {
            s = br.readLine();
            if (s.equals("END")) {
                break;
            }
            solution();
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solution() {
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        sb.append("\n");
    }
}