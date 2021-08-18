public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String str1, str2;
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        str1 = br.readLine();
        str2 = br.readLine();
        solution();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solution() {
        String[] s1 = str1.split(":");
        String[] s2 = str2.split(":");

        int t1 = (Integer.parseInt(s1[0]) * 3600)
            + (Integer.parseInt(s1[1]) * 60)
            + (Integer.parseInt(s1[2]));

        int t2 = (Integer.parseInt(s2[0]) * 3600)
            + (Integer.parseInt(s2[1]) * 60)
            + (Integer.parseInt(s2[2]));

        int ans = 0;
        if (t1 > t2) {
            t2 += 24 * 3600;
            ans = t2 - t1;
        } else if (t1 == t2) {
            ans += 24 * 3600;
        } else {
            ans = t2 - t1;
        }
        sb.append(format("%02d", ans / 3600)).append(":").append(format("%02d", ans % 3600 / 60))
            .append(":").append(format("%02d", ans % 60));
    }
}