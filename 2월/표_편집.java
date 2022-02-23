/*
프로그래머스 Level3
문제 유형 : 이중 연결리스트
걸린 시간 : 2시간 이상, 효율성 실패
*/
class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Node> deleted = new Stack<>();
        List<Node> table = new ArrayList<>();
        
        table.add(new Node(null, null));
        for(int i = 1; i < n; i++) {
            Node prev = table.get(i - 1);
            Node cur = new Node(prev, null);
            prev.next = cur;
            table.add(cur);
        }
        
        Node curr = table.get(k);
        for(String c : cmd) {
            String[] arr = c.split(" ");
            if(arr[0].equals("D")) {
                int down = Integer.parseInt(arr[1]);
                for(int i = 0; i < down; i++) {
                    curr = curr.next;
                }
            }
            
            if(arr[0].equals("U")) {
                int up = Integer.parseInt(arr[1]);
                for(int i = 0; i < up; i++) {
                    curr = curr.prev;
                }
            }
            
            if(arr[0].equals("C")) {
                curr.isDeleted = true;
                deleted.push(curr);
                Node up = curr.prev;
                Node down = curr.next;
                
                if(up != null) up.next = down;
                if(down != null) {
                    down.prev = up;
                    curr = down;
                } else {
                    curr = up;
                }
            }
            
            if(arr[0].equals("Z")) {
                Node reNode = deleted.pop();
                Node up = reNode.prev;
                Node down = reNode.next;
                
                reNode.isDeleted = false;
                if(up != null) {
                    up.next = reNode;
                }

                if(down != null) {
                    down.prev = reNode;
                }
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(table.get(i).isDeleted) answer.append("X");
            else answer.append("O");
        }
        
        return answer.toString();
    }
    
    class Node {
        Node prev;
        Node next;
        boolean isDeleted = false;
        
        public Node(Node prev, Node next) {
            this.prev = prev;
            this.next = next;
        }
    }
}