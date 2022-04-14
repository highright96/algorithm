/*
프로그래머스 Level 2
문제 유형 : 구현
걸린 시간 : 1시간
*/
class Solution {
    public String solution(int[] numbers) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return (s2 + s1).compareTo(s1 + s2);
        });
        
        for(int n : numbers) pq.offer(n);

        String answer = "";
        while(!pq.isEmpty()) {
            answer += String.valueOf(pq.poll());
        }
        
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}