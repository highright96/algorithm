public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());
        
        int[] arr = new int[n + 1];
        
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(stk.nextToken());
        }

        int max = 0, cnt = 1;
        for (int i = x; i <= n; i++) {
            int sum = arr[i] - arr[i - x];
            if (sum > max) {
                cnt = 1;
                max = sum;
            } else if(sum == max){
                cnt++;
            }
        }
        
        if(max == 0){
            bw.write("SAD");
        }else {
            bw.write(max + "\n");
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}