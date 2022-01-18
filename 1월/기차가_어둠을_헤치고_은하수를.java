/*
백준 실버 1
문제 유형 : 구현
걸린 시간 : 50분
*/
public class Main {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] trains = new int[n + 1][22];
        Set<String> record = new HashSet<>();
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(stk.nextToken());
            if (type == 1) {
                ride(trains, Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
            }
            if (type == 2) {
                getOff(trains, Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
            }
            if (type == 3) {
                goBack(trains, Integer.parseInt(stk.nextToken()));
            }
            if (type == 4) {
                goForward(trains, Integer.parseInt(stk.nextToken()));
            }
        }

        for (int i = 1; i < trains.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < trains[i].length; j++) {
                sb.append(trains[i][j]);
            }
            record.add(sb.toString());
        }
        bw.write(record.size() + "\n");
        bw.flush();
        bw.close();
    }

    static void ride(int[][] trains, int num, int pos) {
        trains[num][pos] = 1;
    }

    static void getOff(int[][] trains, int num, int pos) {
        trains[num][pos] = 0;
    }

    static void goBack(int[][] trains, int num) {
        for (int i = 20; i > 0; i--) {
            trains[num][i] = trains[num][i - 1];
        }
    }

    static void goForward(int[][] trains, int num) {
        for (int i = 1; i <= 20; i++) {
            trains[num][i] = trains[num][i + 1];
        }
    }
}