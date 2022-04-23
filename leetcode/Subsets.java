/*
난이도 : medium
문제 유형 : 완전탐색
걸린 시간 : 10분
*/
class Solution {
    
    List<List<Integer>> answer = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        int len = nums.length;
        for(int i = 0; i <= len; i++) {
            back(nums, new ArrayList<>(), 0, 0, i);
        }
        
        return answer;
    }
    
    private void back(int[] nums, List<Integer> output, int idx, int depth, int size) {
        if(depth == size) {
            answer.add(new ArrayList<>(output));
            return;
        }
        
        if(idx >= nums.length) return;
        
        output.add(nums[idx]);
        back(nums, output, idx + 1, depth + 1, size);
        output.remove(output.size() - 1);
        back(nums, output, idx + 1, depth , size);
    }
}