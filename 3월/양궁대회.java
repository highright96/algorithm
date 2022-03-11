/*
프로그래머스 Level 2
문제 유형 : 백트래킹
걸린 시간 : 57분
*/
class Solution {
    
    int max = Integer.MIN_VALUE;
    int[] lion;
    int[] answer = new int[11];
    
    public int[] solution(int n, int[] info) {
        
        lion = new int[11];
        comb(info, lion, 0, n);
        
        if(max <= 0) return new int[]{-1};
        return answer;
    }
    
    private void comb(int[] apeach, int[] lion, int depth, int n) {
        if(n == 0) {
            int diff = compareScore(apeach, lion);
            if(diff <= 0) return;
            if(max < diff) {
                max = diff;
                System.arraycopy(lion, 0, answer, 0, lion.length);
            } else if (max == diff) compareAnswer(lion);
            
            return;
        }
        
        if(depth >= 11) return;
        
        lion[depth] += 1;
        comb(apeach, lion, depth,  n - 1);
        lion[depth] -= 1;
        comb(apeach, lion, depth + 1, n);
    }
    
    private int compareScore(int[] apeach, int[] lion){
        int lionScore = 0, apeachScore = 0;
        for(int i = 0; i < 11; i++) {
            if(lion[i] == 0 && apeach[i] == 0) continue;
            if(lion[i] > apeach[i]) lionScore += (10 - i);
            else apeachScore += (10 - i);
        }
        return lionScore - apeachScore;
    }
    
    private void compareAnswer(int[] lion) {
        for(int i = 10; i >= 0; i--) {
            if(answer[i] > lion[i]) return;
            if(answer[i] < lion[i]) {
                System.arraycopy(lion, 0, answer, 0, lion.length);
                return;
            }
        }
    }
}