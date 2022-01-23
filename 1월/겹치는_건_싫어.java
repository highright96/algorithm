/*
백준 실버 1
문제 유형 : 투포인터
걸린 시간 : 1시간
*/
public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[] arr = new int[n + 2];
        Map<Integer, Integer> map = new HashMap<>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int l = 1, r = 1, max = 0;
        map.put(arr[l], 1);
        while (r <= n) {
            if (map.get(arr[r]) > k) {
                map.put(arr[l], map.get(arr[l]) - 1);
                l++;
            } else {
                max = Math.max(max, r - l + 1);
                r++;
                map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            }
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}