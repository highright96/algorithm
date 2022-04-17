/*
프로그래머스 Level 2
문제 유형 : 정렬
걸린 시간 : 30분
문제 이해하는데 오래 걸림
*/
class Solution {
    public int solution(int[] citations) {
        
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            
            if(citations[i] >= h) {
                answer = Math.max(answer, h);
            }
        }
        
        return answer;
    }
}