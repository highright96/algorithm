/*
프로그래머스 Level 2
문제 유형 : 구현
걸린 시간 : 실패
*/
class Solution {
    public int solution(String name) {
        int answer = 0, move = name.length() - 1;
        
        for(int i = 0; i < name.length(); i++) {
            
            char c = name.charAt(i);
            
            int down = c - 'A';
            int up = 'Z' - c + 1;
            answer += Math.min(down, up);
              
            int aIdx = i + 1;
            while(aIdx < name.length() && name.charAt(aIdx) == 'A'){
                aIdx++;
            }
            move = Math.min(move, i + name.length() - aIdx + i);
        }
        answer += move;
        
        return answer;
    }
}