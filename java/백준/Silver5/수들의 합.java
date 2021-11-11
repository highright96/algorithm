import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    int ans = 0, total = 1, l = 1, r = 1;
    while (l <= r) {
      if (total < n) {
        r++;
        total += r;
      } else {
        if (total == n) {
          ans++;
        }
        total -= l;
        l++;
      }
    }
    bw.write(ans + "");
    bw.flush();
    bw.close();
  }
}