public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String s;
    private static Character[][] arr = new Character[15][5];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[j][i] = s.charAt(j);
            }
        }
        solution();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solution() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] != null) {
                    sb.append(arr[i][j]);
                }
            }
        }
    }
}