/*
프로그래머스 Level3
문제 유형 : BST
걸린 시간 : 2시간
트리를 오랜만에 구현해서 오래걸림.
*/
class Solution {
    public int[][] solution(int[][] nodeinfo) {
        
        int[][] nodes = new int[nodeinfo.length][3];
        for(int i = 0; i < nodeinfo.length; i++) {
            nodes[i][0] = i + 1;
            nodes[i][1] = nodeinfo[i][0];
            nodes[i][2] = nodeinfo[i][1];
        }
        Arrays.sort(nodes, (v1, v2) -> v2[2] - v1[2]);
        
        BST bst = new BST();
        for(int i = 0; i < nodes.length; i++) {
            int number = nodes[i][0];
            int x = nodes[i][1];
            Node node = new Node(number, x);
            bst.add(node);
        }
        bst.preOrder(bst.root);
        bst.postOrder(bst.root);
        
        int[][] answer = new int[2][nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = bst.preHistory.get(i);
        }
        for(int i = 0; i < nodeinfo.length; i++) {
            answer[1][i] = bst.postHistory.get(i);
        }
        
        return answer;
    }
    
    class Node {
        int number, x;
        Node left;
        Node right;
        
        public Node(int number, int x) {
            this.number = number;
            this.x = x;
        }
    }
    
    class BST {
        Node root;
        List<Integer> preHistory = new ArrayList<>();
        List<Integer> postHistory = new ArrayList<>();
        
        public void add(Node node) {
            if(root == null) {
                root = node;
                return;
            }
            
            Node curr = root;
            while(true) {
                if(curr.x > node.x) {
                    if(curr.left == null) {
                        curr.left = node;
                        break;
                    }
                    curr = curr.left;
                } else if(curr.x < node.x) {
                    if(curr.right == null) {
                        curr.right = node;
                        break;
                    }
                    curr = curr.right;
                }
            }
        }
        
        public void preOrder(Node node){
            if(node == null) return;
            preHistory.add(node.number);
            if(node.left != null) preOrder(node.left);
            if(node.right != null) preOrder(node.right);
        }
        
        public void postOrder(Node node){
            if(node == null) return;
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            postHistory.add(node.number);
        }
    }
}