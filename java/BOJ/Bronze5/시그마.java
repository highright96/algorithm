import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Long a, b;

    public static void main(String[] args) throws IOException {

        //int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        a = Long.parseLong(stk.nextToken());
        b = Long.parseLong(stk.nextToken());
        solve();

        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        Long n = a > b  ? (a + b) * (a - b + 1) / 2 : (a + b) * (b - a + 1) / 2;
        bw.write(String.valueOf(n));
    }
}