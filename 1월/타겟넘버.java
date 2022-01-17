/*
프로그래머스 Level 2
문제 유형 : 백트래킹
걸린 시간 : 11분
*/
class Solution {
    
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        back(numbers,0,target,0);
        return answer;
    }
    
    static void back(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        back(numbers, depth+1, target, sum + numbers[depth] * 1);
        back(numbers, depth+1, target, sum + numbers[depth] * -1);
    }
}