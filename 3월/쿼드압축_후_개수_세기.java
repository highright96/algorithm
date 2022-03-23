/*
프로그래머스 Level 2
문제 유형 : 분할정복
걸린 시간 : 1시간
*/
class Solution {
    
    int zero = 0, one = 0;
    
    public int[] solution(int[][] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(arr[i][j] == 0) zero++;
                else one++;
            }
        }
        
        recur(arr, 0, 0, len - 1, len - 1, len);
        
        int[] answer = {zero, one};
        return answer;
    }
    
    private void recur(int[][] arr, int sr, int sc, int er, int ec, int cnt) {
        if(sr >= er || sc >= ec) return;
        
        int zCnt = 0;
        for(int i = sr; i <= er; i++) {
            for(int j = sc; j <= ec; j++) {
                if(arr[i][j] == 0) zCnt++; 
            }
        }
        if(zCnt == cnt * cnt) {
            zero -= cnt * cnt - 1;
            return;
        } else if(zCnt == 0) {
            one -= cnt * cnt - 1;
            return;
        }
        
        recur(arr, sr, sc, er - cnt / 2, ec - cnt / 2, cnt / 2);
        recur(arr, sr, sc + cnt / 2, er - cnt / 2, ec, cnt / 2);
        recur(arr, sr + cnt / 2, sc, er, ec - cnt / 2, cnt / 2);
        recur(arr, sr + cnt / 2, sc + cnt / 2, er, ec, cnt / 2);
    }
}