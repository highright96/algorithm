public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static String[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        solution();
        for (int i = 0; i < n; i++) {
            if(i == 0){
                bw.write(arr[i] + "\n");
            }else if (!arr[i].equals(arr[i - 1])) {
                bw.write(arr[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void solution() {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });
    }
}