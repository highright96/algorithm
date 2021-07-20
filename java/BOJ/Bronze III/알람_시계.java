import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n, m;

    public static void main(String[] args) throws IOException {

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = nextInt(stk);
        m = nextInt(stk);

        solve();

        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        if (m < 45) {
            m = 60 + (m - 45);
            n = (n == 0) ? 23 : n - 1;
            bw.write(n + " " + m);
            return;
        }
        bw.write(n + " " + (m - 45));
    }

    public static int nextInt(StringTokenizer stk) {
        return Integer.parseInt(stk.nextToken());
    }
}