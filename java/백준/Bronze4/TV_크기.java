import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TV_크기 {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n, h, w;

    public static void main(String[] args) throws IOException {

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = nextInt(stk);
        h = nextInt(stk);
        w = nextInt(stk);

        solve();

        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        double a = sqrt(pow(n, 2) * (pow(w, 2) / (pow(w, 2) + pow(h, 2))));
        double b = a * h / w;
        bw.write((int) b + " " + (int) a);
    }

    public static int nextInt(StringTokenizer stk) {
        return Integer.parseInt(stk.nextToken());
    }
}

