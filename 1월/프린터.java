/*
프로그래머스 Level 2
문제 유형 : 스택, 큐
걸린 시간 : 25분
*/
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < priorities.length; i++){
            pq.offer(priorities[i]);
            if(i == location) {
                q.offer(new Node(priorities[i], true));
            } else {
                q.offer(new Node(priorities[i], false));
            }
        }
        
        int answer = 1, max = pq.poll();
        while(!q.isEmpty()){
            Node node = q.peek();
            if(node.v == max && node.isChk){
                return answer;
            }
            if(node.v == max && !node.isChk){
                max = pq.poll();
                q.poll();
                answer++;
            }
            if(node.v < max){
                q.offer(q.poll());
            }
        }
        return answer;
    }
    
    static class Node {
        int v;
        boolean isChk;

        public Node(int v, boolean isChk) {
            this.v = v;
            this.isChk = isChk;
        }
    }
}