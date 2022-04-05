/*
프로그래머스 Level 2
문제 유형 : 스택
걸린 시간 : 10분
*/
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
            
            while(stack.size() >= 2) {
                char top = stack.pop();
                char prev = stack.peek();
                
                if(top == prev) {
                    stack.pop();
                } else {
                    stack.push(top);
                    break;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}