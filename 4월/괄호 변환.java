/*
프로그래머스 Level 2
문제 유형 : 구현, 재귀
걸린 시간 : 30분
*/
class Solution {
    public String solution(String p) {
        
        if (check(p)) {
            return p;
        }

        return divide(p);
    }

    private String divide(String s) {

        if (s.length() == 0) {
            return "";
        }

        int uIdx = index(s);
        String u = s.substring(0, uIdx + 1);
        String v = s.substring(uIdx + 1);

        StringBuilder uSb = new StringBuilder(u);

        if (check(u)) {
            uSb.append(divide(v));
            return uSb.toString();
        }

        StringBuilder sb = new StringBuilder();

        sb.append("(");
        sb.append(divide(v));
        sb.append(")");

        uSb.deleteCharAt(0);
        uSb.deleteCharAt(uSb.length() - 1);

        sb.append(reverse(uSb.toString()));

        return sb.toString();
    }

    private int index(String s) {
        int rCnt = 0, lCnt = 0, idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                rCnt++;
            } else {
                lCnt++;
            }

            if (rCnt == lCnt) {
                idx = i;
                break;
            }
        }

        return idx;
    }

    private boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                char p = stack.peek();
                if (p == '(' && c == ')') {
                    stack.pop();
                    continue;
                }
            }

            stack.push(c);
        }

        return stack.size() == 0;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                sb.append('(');
            } else {
                sb.append(')');
            }
        }

        return sb.toString();
    }
}