public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        if(N % 2 == 0){
            bw.write("CY");
        } else {
            bw.write("SK");
        }
    }
}