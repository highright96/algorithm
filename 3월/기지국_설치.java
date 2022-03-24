/*
프로그래머스 Level 3
문제 유형 : 시뮬레이션
걸린 시간 : 1시간
*/
class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int answer = 0;
        int pos = 1;
        int count = 0;
        
        //기지국 사이의 전파 x 아파트
        for(int i = 1; i < stations.length; i++) {
            count = stations[i] - stations[i - 1] - 2 * w - 1;
            answer += Math.ceil((double) count / (2 * w + 1));
        }
        
        //시작 - 첫 기지국
        if(stations[0] != 0) {
            count = stations[0] - 1 - w;
            answer += Math.ceil((double) count / (2 * w + 1));
        }
        
        //마지막 기지국 - 끝
       if(stations[stations.length - 1] != n) {
            count = n - stations[stations.length - 1] - w;
            answer += Math.ceil((double) count / (2 * w + 1));
       }
        
        return answer;
    }
}