/*
프로그래머스 Level 2
문제 유형 : 구현
걸린 시간 : 1시간
*/
class Solution {
    public String solution(int n) {
        
        int[] num = {4, 1, 2};
        StringBuilder sb = new StringBuilder();
        
        if(n <= 3) {
            sb.append(num[n % 3]);
        } else {           
            while(n > 0) {
                int remainder = n % 3;
                n /= 3;
                if(remainder == 0) n--;
                sb.append(num[remainder]);
            }
        }
        
        return sb.reverse().toString();
    }
}