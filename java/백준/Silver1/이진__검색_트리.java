public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String str = "";
        while ((str = br.readLine()) != null && !str.equals("")) {
            list.add(Integer.parseInt(str));
        }
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        Node root = new Node(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            insert(root, list.get(i));
        }
        postOrder(root);
    }

    static void insert(Node root, int data) {
        if (data < root.data) {
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                insert(root.left, data);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                insert(root.right, data);
            }
        }
    }

    static void postOrder(Node root) throws IOException {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        bw.write(root.data + "\n");
    }

    static class Node {

        int data;
        Node left = null;
        Node right = null;

        public Node(int data) {
            this.data = data;
        }
    }
}