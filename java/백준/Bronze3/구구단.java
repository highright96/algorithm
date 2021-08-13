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

        solve();

        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        for (int i = 1; i < 10; i++) {
            bw.write(n + " * " + i + " = " + n * i + "\n");
        }
    }

    public static int nextInt(StringTokenizer stk) {
        return Integer.parseInt(stk.nextToken());
    }
}