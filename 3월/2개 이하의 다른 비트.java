/*
프로그래머스 Level 2
문제 유형 : 규칙 찾기
걸린 시간 : 1시간
*/
class Solution {
    public long[] solution(long[] numbers) {
        
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String b = Long.toString(numbers[i], 2);
                if(b.contains("0")) {
                    int zeroIdx = b.lastIndexOf("0");
                    b = b.substring(0, zeroIdx) + "10" + b.substring(zeroIdx + 2);
                } else {
                    b = "10" + b.substring(1).replace("0", "1");
                }
                answer[i] = Long.parseLong(b, 2);
            }
        }
        return answer;
    }
}