/*
프로그래머스 Level 2
문제 유형 : 문자열
걸린 시간 : 10분
*/
class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(s.charAt(0)));
        
        for(int i = 1; i < s.length(); i++) {
            
            char cur = s.charAt(i);
            char prev = s.charAt(i - 1);
            
            if(prev == ' ' && (cur >= 'a' && cur <= 'z')) {
                sb.append(Character.toUpperCase(cur));
                continue;
            }
            
            if(prev != ' ' && (cur >= 'A' && cur <= 'Z')) {
                sb.append(Character.toLowerCase(cur));
                continue;
            }
            
            sb.append(cur);
        }
        
        return sb.toString();
    }
}