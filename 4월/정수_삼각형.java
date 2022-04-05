/*
프로그래머스 Level 3
문제 유형 : DP
걸린 시간 : 20분
*/
class Solution {
    public int solution(int[][] triangle) {
        
        int answer = 0;
        int[][] sum = new int[triangle.length][triangle.length];
        sum[0][0] = triangle[0][0];

        for(int y = 1; y < triangle.length; y++) {
            for(int x = 0; x < triangle[y].length; x++) {
                int max = 0;
                
                if(x - 1 < 0) {
                    max = sum[y - 1][x];
                } else {
                    max = Math.max(sum[y - 1][x], sum[y - 1][x - 1]);
                }
                
                sum[y][x] = max + triangle[y][x];
                answer = Math.max(answer, sum[y][x]);
            }
        }
        return answer;
    }
}