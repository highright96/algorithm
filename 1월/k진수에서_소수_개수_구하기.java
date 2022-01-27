/*
프로그래머스 Level 2
문제 유형 : 구현
걸린 시간 : 25분
*/
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String number = conversion(n, k);
        String[] sArr = number.split("0");
        for(String s : sArr){
            if(!s.equals("") && isPrime(Long.parseLong(s))){
                answer++;
            }
        }
        
        return answer;
    }
    
    static String conversion(int num, int N){
        StringBuilder sb = new StringBuilder();
	    int current = num;
	    
        while(current > 0){
            if(current % N < 10){
                sb.append(current % N);
            } else {
                sb.append((char)(current % N - 10 + 'A'));
            }
            current /= N;
        }
        return sb.reverse().toString();
    }
    
    static boolean isPrime(long num){
        if(num == 1){
            return false;
        }
        
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}