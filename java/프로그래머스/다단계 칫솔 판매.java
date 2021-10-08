class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] total = new int[enroll.length];
        
        for(int i = 0; i<enroll.length; i++){
            map.put(enroll[i], i);
        }
        
        for(int i = 0; i<seller.length; i++){
            int money = amount[i] * 100; //판매금액
            String cur = seller[i];
            while(!cur.equals("-")){
                int idx = map.get(cur);
                int fee = money / 10; //수수료
                total[idx] += money - fee;
                cur = referral[idx];
                money = fee;
                if(fee < 1){
                    break;
                }
            }
        }
        return total;
    }
}