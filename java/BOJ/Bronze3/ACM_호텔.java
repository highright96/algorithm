import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n, h, w, m;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            h = Integer.parseInt(stk.nextToken());
            w = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());
            solve();
        }

        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        int f, k;
        if (m % h == 0) {
            f = h * 100;
            k = m / h;
        } else {
            f = m % h * 100;
            k = m / h + 1;
        }
        bw.write(f + k + "\n");
    }
}