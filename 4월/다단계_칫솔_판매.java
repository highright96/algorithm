/*
프로그래머스 Level 3
문제 유형 : 해쉬, 구현
걸린 시간 : 35분
*/
class Solution {
    
    //구성원, 추천인
    Map<String, String> map = new HashMap<>();
    //구성원, 이익 합계
    Map<String, Integer> result = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        for(int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], referral[i]);
        }
        
        for(int i = 0; i < seller.length; i++) {
            cal(seller[i], 100 * amount[i]);
        }
        
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = result.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
    
    private void cal(String seller, int amount) {
        int profit = amount;
        
        while(!seller.equals("-")) {
            result.put(seller, result.getOrDefault(seller, 0) + profit - profit / 10);
            
            //다음 seller는 추천인
            seller = map.get(seller);
            profit = profit / 10;
            
            if(profit == 0) break;
        }
    }
}