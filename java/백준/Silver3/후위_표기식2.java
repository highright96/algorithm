public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static String str;
    private static List<Double> arr = new ArrayList<>();
    private static Stack<Double> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        str = stk.nextToken();
        for (int i = 0; i < n; i++) {
            arr.add(Double.parseDouble(br.readLine()));
        }
        solve();
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        Double a, b;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 65) {
                stack.push(arr.get(str.charAt(i) - 'A'));
            } else {
                if (str.charAt(i) == '+') {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b + a);
                } else if (str.charAt(i) == '-') {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                } else if (str.charAt(i) == '*') {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                } else if (str.charAt(i) == '/') {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                } else if (str.charAt(i) == '%') {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b % a);
                }
            }
        }
        bw.write(format("%.2f", stack.pop()));
    }
}