/*
프로그래머스 Level 2
문제 유형 : 스택
걸린 시간 : 이중for문->10분, 스택->실패
*/
class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        
        /*
        이중for문  => O(N^2)
        for(int i = 0; i < prices.length - 1; i++) {
            int price = prices[i];
            for(int j = i + 1; j < prices.length; j++) {
                int nPrice = prices[j];
                if(nPrice < price || j == prices.length - 1) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        answer[prices.length - 1] = 0;
        */
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0);
        for(int i = 1; i < prices.length; i++) {
            
            if(prices[stack.peek()] <= prices[i]) {
                stack.push(i);
            } else {
                while(true) {
                    if(stack.isEmpty() || prices[stack.peek()] <= prices[i]) {
                        stack.push(i);
                        break;
                    }
                    
                    int idx = stack.pop();
                    answer[idx] = i - idx;
                }
            }
        }
        
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }
        
        return answer;
    }
}