/*
프로그래머스 Level 2
문제 유형 : 백트래킹
걸린 시간 : 40분
*/
class Solution {
    
    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    Map<Character, Integer> map = new HashMap<>();
    int answer = 0;
    
    
    public int solution(int n, String[] data) {
        back(data, 0);
        return answer;
    }
    
    private void back(String[] data, int depth) {
        if(depth == 8) {
            if(check(data)) answer += 1;
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            char c = friends[i];
            if(!map.containsKey(c)) {
                map.put(c, depth + 1);
                back(data, depth + 1);
                map.remove(c);
            }
        }
    }
    
    private boolean check(String[] data) {
        for(String s : data) {
            char c1 = s.charAt(0);
            char c2 = s.charAt(2);
            char c3 = s.charAt(3);
            int distance = Integer.parseInt(String.valueOf(s.charAt(4))); 
            int d = Math.abs(map.get(c1) - map.get(c2)) - 1;
            if(c3 == '=' && d != distance) return false;
            if(c3 == '>' && d <= distance) return false; 
            if(c3 == '<' && d >= distance) return false; 
        }
        return true;
    }
}