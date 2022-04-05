/*
프로그래머스 Level 2
문제 유형 : 문자열
걸린 시간 : 10분
*/
class Solution {

    boolean[] visit;
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        visit = new boolean[numbers.length];
        comb(numbers, target, 0, 0);
        return answer;
    }
    
    private void comb(int[] numbers, int target, int output, int depth) {
        if(depth == numbers.length) {
            if(output == target) answer++;
            return;
        }
        
        comb(numbers, target, output + numbers[depth], depth + 1);
        comb(numbers, target, output - numbers[depth], depth + 1);
    }
}