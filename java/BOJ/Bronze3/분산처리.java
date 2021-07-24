import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n, a, b;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            solve();
        }

        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        b = b % 4 == 0 ? 4 : b % 4;
        int pow = (int) Math.pow(a, b);
        int ans = pow % 10 == 0 ? 10 : pow % 10;
        bw.write(ans + "\n");
    }
}