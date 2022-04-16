/*
프로그래머스 Level 2
문제 유형 : 구현
걸린 시간 : 10분
*/
class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 1;
        
        while(true) {
            a = a % 2 == 0 ? a : a + 1; //a를 짝수로 변경
            b = b % 2 == 0 ? b : b + 1; //b를 짝수로 변경
            
            if(a == b) break; //짝수로 변경한 번호가 같으면 싸우는 라운드
            
            a /= 2; //다음 라운드 번호로 변경
            b /= 2; //다음 라운드 번호로 변경
            
            round++;
        }

        return round;
    }
}