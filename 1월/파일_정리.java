public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        SortedMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String ext = br.readLine().split("\\.")[1];
            map.put(ext, map.getOrDefault(ext, 0) + 1);
        }
        for (String ext : map.keySet()) {
            bw.write(ext + " " + map.get(ext));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}