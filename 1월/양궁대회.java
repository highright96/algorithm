/*
프로그래머스 Level 2
문제 유형 : 백트래킹
걸린 시간 : 1시간 30분
*/
class Solution {
    
    static int max = 0;
    static int[] maxScore;
    
    public int[] solution(int n, int[] info) {
        maxScore = new int[11];
        int[] score = new int[11];

        back(info, score, n, 0);

        if(max == 0) return new int[]{-1};
        
        int[] answer = new int[11];
        for (int i = 0; i <= 10; i++) {
            answer[i] = maxScore[i];
        }
        return answer;
    }
    
    static void back(int[] info, int[] score, int n, int depth){
        if (n == 0) {
            int diff = getDiff(info, score);
            compare(diff, score);
            return;
        }

        if (depth == 11) {
            return;
        }
        
        score[depth] += 1;
        back(info, score, n - 1, depth);
        score[depth] -= 1;
        back(info, score, n, depth + 1);
    }
    
    static int getDiff(int[] info, int[] score) {
        int apeach = 0, lion = 0;
        for (int i = 0; i <= 10; i++) {
            if (score[i] > info[i]) {
                lion += 10 - i;
            }
            if (info[i] != 0 && info[i] >= score[i]) {
                apeach += 10 - i;
            }
        }
        return lion - apeach;
    }
    
    static void compare(int diff, int[] score) {
        if(diff <= 0) return;
        if (max > diff) return;
        if (max < diff) {
            System.arraycopy(score, 0, maxScore, 0, 11);
            max = diff;
        }
        if(max == diff) {
            for (int i = 10; i >= 0; i--) {
                if (maxScore[i] > score[i]) break;
                if (maxScore[i] < score[i]) {
                    System.arraycopy(score, 0, maxScore, 0, 11);
                    max = diff;
                    break;
                }
            }
        }
    }
}