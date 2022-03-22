/*
프로그래머스 Level 2
문제 유형 : 스택
걸린 시간 : 23분
*/
class Solution {
    public int solution(String s) {
        
        int answer = 0;
        int len = s.length();
        while(len > 0) {
            if(check(s)) answer++;
            s = s.substring(1, s.length()) + s.charAt(0);
            len--;
        }
        
        return answer;
    }
    
    private boolean check(String s){
        Deque<Character> deque = new ArrayDeque<>(); 
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{') deque.offerLast(c);
            else {
                if(deque.size() == 0) return false;
                
                char prev = deque.peekLast();
                if(c == ']' && prev == '[') deque.pollLast();
                else if(c == ')' && prev == '(') deque.pollLast();
                else if(c == '}' && prev == '{') deque.pollLast();
                else return false;
            }
        }
        return deque.size() == 0;
    }
}