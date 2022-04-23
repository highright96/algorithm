/*
난이도 : medium
문제 유형 : 조합
걸린 시간 : 5분
*/
class Solution {
    
    List<List<Integer>> answer = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        comb(nums, new boolean[nums.length], new int[nums.length], 0);
        return answer;
    }
    
    private void comb(int[] nums, boolean[] visit, int[] output, int depth) {
        if(depth == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for(int o : output) {
                tmp.add(o);
            }
            
            answer.add(tmp);        
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!visit[i]) {
                output[depth] = nums[i];
                visit[i] = true;
                comb(nums, visit, output, depth + 1);
                visit[i] = false;
            }
        }
    }
}