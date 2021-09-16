public class Main {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static TreeMap<Integer, Integer> tree;

  public static void main(String[] args) throws IOException {
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      tree = new TreeMap<>();
      int M = Integer.parseInt(br.readLine());
      while (M-- > 0) {
        String s = br.readLine();
        String[] sp = s.split(" ");
        if (sp[0].equals("I")) {
          int key = Integer.parseInt(sp[1]);
          tree.put(key, tree.getOrDefault(key, 0) + 1);
        } else if (sp[0].equals("D") && !tree.isEmpty()) {
          if (sp[1].equals("1")) {
            int maxKey = tree.lastKey();
            removeTree(maxKey);
          } else {
            int minKey = tree.firstKey();
            removeTree(minKey);
          }
        }
      }
      if (tree.isEmpty()) {
        bw.write("EMPTY\n");
      } else {
        bw.write(tree.lastKey() + " " + tree.firstKey() + "\n");
      }
    }
    bw.close();
  }

  public static void removeTree(int key) {
    if (tree.get(key) > 1) {
      tree.put(key, tree.get(key) - 1);
    } else {
      tree.remove(key);
    }
  }
}