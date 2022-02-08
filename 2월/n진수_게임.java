/*
프로그래머스 Level 2
문제 유형 : 문자열, 구현
걸린 시간 : 1시간 20분
*/
class Solution {
        
    public String solution(int n, int t, int m, int p) {
        
        int idx = 1, number = 0;
        int maxIdx = t * m - (m - p);
        StringBuilder sb = new StringBuilder();
        while(idx <= maxIdx) {
            String tmp = toNthNumber(number, n);
            sb.append(tmp);
            number++;
            idx += tmp.length();
        }

        StringBuilder answer = new StringBuilder();
        while(p <= maxIdx) {
            answer.append(sb.charAt(p - 1));
            p += m;
        }
        
        return answer.toString();
    }
    
    static String toNthNumber(int n, int nth) {
        if(n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int tmp = n % nth;
            if(tmp >= 10) sb.append((char) (tmp + 55));
            else sb.append(tmp);
            n /= nth;
        }
        return sb.reverse().toString();
    }
}