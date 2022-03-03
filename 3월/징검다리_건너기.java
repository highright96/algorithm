/*
프로그래머스 Level 3
문제 유형 : 이분탐색
걸린 시간 : 1시간 30분
테스트케이스 3번, 효율성 13번에서 오래걸림 
*/
class Solution {
    public int solution(int[] stones, int k) {
        
        int l = 0, r = 0, mid = 0;
        for(int stone : stones) {
            r = Math.max(stone, r);
        }
        
        while(l <= r) {
            mid = (l + r) / 2;
            if(!check(stones, k, mid)) r = mid - 1;
            else l = mid + 1;
        }
        
        return r;
    }
    
    private boolean check(int[] stones, int k, int mid) {
        int cnt = 0;
        for(int stone : stones) {
            if(stone < mid) cnt++;
            else cnt = 0;
            if(cnt >= k) return false;
        }
        return true;
    }
}