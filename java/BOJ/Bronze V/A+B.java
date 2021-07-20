//BOJ1000 A+B
import static java.lang.String.valueOf;

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
    private static int answer;

    public static void main(String[] args) throws IOException {

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = nextInt(stk);
        m = nextInt(stk);

        solve();

        bw.write(valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void solve() {
        answer = n + m;
    }

    public static int nextInt(StringTokenizer stk) {
        return Integer.parseInt(stk.nextToken());
    }
}

