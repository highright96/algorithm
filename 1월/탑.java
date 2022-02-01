/*
백준 Gold5
문제 유형 : 스택
걸린 시간 : 40분
*/
public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] tours = new int[n];
        int[] answer = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tours[i] = Integer.parseInt(stk.nextToken());
        }

        Stack<Tour> stack = new Stack<>();

        stack.push(new Tour(tours[0], 1));
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty()) {
                Tour tmp = stack.peek();
                if (tmp.h > tours[i]) {
                    answer[i] = tmp.p;
                    break;
                }
                if (tmp.h < tours[i]) {
                    stack.pop();
                }
            }
            stack.push(new Tour(tours[i], i + 1));
        }

        for (int ans : answer) {
            bw.write(ans + " ");
        }

        bw.flush();
        bw.close();
    }

    static class Tour {

        int h;
        int p;

        public Tour(int h, int p) {
            this.h = h;
            this.p = p;
        }
    }
}