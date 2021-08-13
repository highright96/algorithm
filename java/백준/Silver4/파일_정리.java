public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Map<String, Integer> map;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        map = new TreeMap<>();
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String s = br.readLine();
            solution(s);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void solution(String s) {
        int idx = s.indexOf(".");
        String ext = s.substring(idx + 1);
        if (!map.containsKey(ext)) {
            map.put(ext, 1);
        } else {
            map.put(ext, map.get(ext) + 1);
        }
    }
}