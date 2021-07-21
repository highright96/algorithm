import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n, t, a, b;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            t = Integer.parseInt(stk.nextToken());
            solve();
        }
        if (a < b) {
            bw.write("Y " + a);
        } else if (a == b) {
            bw.write("Y M " + a);
        } else {
            bw.write("M " + b);
        }

        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        a += (t / 30 + 1) * 10;
        b += (t / 60 + 1) * 15;
    }
}