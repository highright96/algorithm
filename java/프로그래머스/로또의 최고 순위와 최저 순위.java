class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0, empty = 0;
        for(int i = 0; i < 6; i++){
            if(lottos[i] == 0){
                empty++;
            }
            for(int j = 0; j < 6; j++){
                if(lottos[i] == win_nums[j]){
                    cnt++;
                }
            }
        }
        int best = cnt + empty == 0 ? 1 : cnt + empty;
        int worst = cnt == 0 ? 1 : cnt;  
        int[] ans = {7 - best, 7 - worst};
        return ans;
    }
}