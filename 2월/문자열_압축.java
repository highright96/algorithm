/*
프로그래머스 Level2
문제 유형 : 문자열, 구현
걸린 시간 : 35분
*/
class Solution {
    public int solution(String s) {
        
        int maxLen = s.length() / 2;
        int answer = Integer.MAX_VALUE;
        
        if(maxLen == 0) return 1;
        
        for(int len = 1; len <= maxLen; len++) {
            int cnt = 1;
            String curStr = s;
            String prevSub = "";
            StringBuilder output = new StringBuilder();
            
            while(len <= curStr.length()) {
                String sub = curStr.substring(0, len);
                if(prevSub.equals(sub)) cnt++;
                else {
                    output.append(cnt > 1 ? cnt : "").append(prevSub);
                    prevSub = sub;
                    cnt = 1;
                }
                curStr = curStr.substring(len, curStr.length());
            }
            
            output.append(cnt > 1 ? cnt : "").append(prevSub).append(curStr);
            answer = Math.min(answer, output.toString().length());
        }
        return answer;
    }
}