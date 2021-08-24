public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String s = "";
    private static boolean isMo;
    private static char[] chars = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        while (true) {
            s = br.readLine();
            if (s.equals("end")) {
                break;
            }
            boolean solution = solution();
            if (solution) {
                bw.write("<" + s + "> is acceptable.\n");
            } else {
                bw.write("<" + s + "> is not acceptable.\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static boolean isVe(char c) {
        for (char aChar : chars) {
            if (aChar == c) {
                return true;
            }
        }
        return false;
    }

    static boolean solution() throws IOException {
        int l = s.length();
        isMo = false;
        int m = 0, j = 0;
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (isVe(c)) {
                isMo = true;
                m += 1;
                j = 0;
            } else {
                j += 1;
                m = 0;
            }
            if (m == 3 || j == 3) {
                return false;
            }
            if (i > 0 && c == s.charAt(i - 1)) {
                if (c != 'o' && c != 'e') {
                    return false;
                }
            }
        }
        return isMo;
    }
}