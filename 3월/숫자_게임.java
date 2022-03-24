/*
프로그래머스 Level 3
문제 유형 : 그리디, 정렬
걸린 시간 : 40분
*/
class Solution {
    public int solution(int[] A, int[] B) {
        
        int answer = 0, aIdx = A.length - 1, bIdx = B.length - 1;
        
        Arrays.sort(A);
        Arrays.sort(B);
                
        while(aIdx >= 0) {
            int a = A[aIdx], b = B[bIdx];
            if(a < b) {
                aIdx--;
                bIdx--;
                answer += 1;
            } else {
                aIdx--;
            } 
        }
        
        return answer;
    }
}