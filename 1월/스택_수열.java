public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            arr[i] = m;
        }

        int aPos = 0;
        StringBuilder ans = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            ans.append("+\n");
            while (!stack.isEmpty() && arr[aPos] == stack.peek()) {
                stack.pop();
                aPos++;
                ans.append("-\n");
            }
        }

        if (!stack.isEmpty()) {
            bw.write("NO");
        } else {
            bw.write(ans.toString());
        }
        bw.flush();
        bw.close();
    }
}