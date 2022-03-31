/*
프로그래머스 Level 3
문제 유형 : 우선순위 큐, 그리디
걸린 시간 : 15분
*/
class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        long answer = 0;
        
        for(int work : works) {
            pq.offer(work);
        }        
        
        while(n > 0) {
            int k = pq.poll() - 1;
            pq.offer(k);    
            n--;
        }
        
        while(!pq.isEmpty()) {
            long k = (long) pq.poll();
            if(k <= 0) continue;
            answer += k * k;
        }
        
        return answer;
    }
}