/*
프로그래머스 Level 2
문제 유형 : 백트래킹
걸린 시간 : 2시간 이상
*/
class Solution {
    
    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    int answer = 0;
    
    public int solution(int n, String[] data) {
        back(new String[8], new boolean[8], 0, data);
        return answer;
    }
    
    void back(String[] output, boolean[] visited, int depth, String[] data) {
        if(depth == 8) {
            if(validateData(output, data)) answer++;
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = friends[i];
                back(output, visited, depth + 1, data);
                visited[i] = false;
            }
        }
    }
    
    boolean validateData(String[] output, String[] data) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 8; i++) {
            sb.append(output[i]);
        }
        String rOutput = sb.toString();
        
        for(String s : data) {
            int p1 = rOutput.indexOf(s.charAt(0));
            int p2 = rOutput.indexOf(s.charAt(2));
            char op = s.charAt(3);
            
            int rGap = Math.abs(p1 - p2) - 1;
            int gap = s.charAt(4) - '0';
            
            if(op == '>' && rGap <= gap) return false;
            if(op == '<' && rGap >= gap) return false;  
            if(op == '=' && rGap != gap) return false;
        }
        return true;
    }
}