/*
프로그래머스 Level 2
문제 유형 : 완전탐색
걸린 시간 : 20분
*/
class Solution {
    
    boolean[] visit;
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        back(dungeons, new int[dungeons.length], 0, k);
        return answer;
    }
    
    private void back(int[][] dungeons, int[] routes, int depth, int k) {
        if(depth == dungeons.length) {
            check(dungeons, routes, k);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visit[i]) {
                routes[depth] = i;
                visit[i] = true;
                back(dungeons, routes, depth + 1, k);
                visit[i] = false;
            }
        }
    }
    
    private void check(int[][] dungeons, int[] routes, int k) {
        int count = 0;
        for(int route : routes) {
            if(k < dungeons[route][0]) break;
            k -= dungeons[route][1];
            count++;
        }
        
        answer = Math.max(answer, count);
    }
}