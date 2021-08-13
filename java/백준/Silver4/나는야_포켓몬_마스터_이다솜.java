import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Map<String, Integer> map = new HashMap<>();
    private static String[] arr;
    private static String str;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        arr = new String[n + 1];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            str = stk.nextToken();
            map.put(str, i + 1);
            arr[i + 1] = str;
        }

        while (m-- > 0) {
            stk = new StringTokenizer(br.readLine());
            str = stk.nextToken();
            solve();
        }
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        try {
            int i = Integer.parseInt(str);
            bw.write(arr[i] + "\n");
        } catch (NumberFormatException e) {
            bw.write(map.get(str) + "\n");
        }
    }
}