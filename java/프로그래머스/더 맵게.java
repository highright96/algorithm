class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville){
            queue.add(i);
        }
        
        int cnt = 0;
        while(queue.peek() < K){
            if(queue.size() >= 2){
                int q1 = queue.poll();
                int q2 = queue.poll();
                int q3 = q1 + (q2 * 2);
                queue.add(q3);
                cnt++;
            } else {
                return -1;
            }
        }
        return cnt;
    }
}