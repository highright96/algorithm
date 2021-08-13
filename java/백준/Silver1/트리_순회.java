public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char a, b, c;
    private static Tree tree = new Tree();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a = stk.nextToken().charAt(0);
            b = stk.nextToken().charAt(0);
            c = stk.nextToken().charAt(0);
            tree.insert(a, b, c);
        }
        solve();
        bw.flush();
        bw.close();
    }

    public static void solve() throws IOException {
        tree.preOrder(tree.root);
        bw.write("\n");
        tree.inOrder(tree.root);
        bw.write("\n");
        tree.postOrder(tree.root);
    }

    static class Node {

        char data;
        Node left = null;
        Node right = null;

        public Node(char data) {
            this.data = data;
        }
    }

    static class Tree {

        Node root;

        void insert(char data, char left, char right) {
            if (this.root == null) {
                root = new Node(data);
                if (left != '.') {
                    root.left = new Node(left);
                }
                if (right != '.') {
                    root.right = new Node(right);
                }
            } else {
                search(root, data, left, right);
            }
        }

        void search(Node root, char data, char left, char right) {
            if (root == null) {
                return;
            }
            if (root.data == data) {
                if (left != '.') {
                    root.left = new Node(left);
                }
                if (right != '.') {
                    root.right = new Node(right);
                }
            } else {
                search(root.left, data, left, right);
                search(root.right, data, left, right);
            }
        }

        void preOrder(Node root) throws IOException {
            bw.write(root.data);
            if (root.left != null) {
                preOrder(root.left);
            }
            if (root.right != null) {
                preOrder(root.right);
            }
        }

        void inOrder(Node root) throws IOException {
            if (root.left != null) {
                inOrder(root.left);
            }
            bw.write(root.data);
            if (root.right != null) {
                inOrder(root.right);
            }
        }

        void postOrder(Node root) throws IOException {
            if (root.left != null) {
                postOrder(root.left);
            }
            if (root.right != null) {
                postOrder(root.right);
            }
            bw.write(root.data);
        }
    }
}