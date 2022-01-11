/*
프로그래머스 Level 2
문제 유형 : 스택, 큐
걸린 시간 : 25분
*/
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i<progresses.length; i++){
            int day = (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
            days.add(day);
        }
        
        int max = 0, count = 0;
        while(!days.isEmpty()){
            int day = days.poll();
            if(day > max){
                if(count != 0){
                    answer.add(count);
                }
                count = 1;
                max = day;
            } else {
                count++;
            }
        }
        answer.add(count);
        
        int[] ans = new int[answer.size()];
        for(int i = 0; i<answer.size(); i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}