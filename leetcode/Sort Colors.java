/*
난이도 : medium
문제 유형 : 투 포인터
걸린 시간 : 방법 1 : 15분, 방법 2 : 실패
*/
class Solution {
    public void sortColors(int[] nums) {
        /*
        방법 1 : 무지성 for문
        시간복잡도 : O(N)
        공간복잡도 : O(N)
        
        int[] count = new int[3];
        int[] tmp = new int[nums.length];
        
        for(int num : nums) {
            count[num]++;
        }
        
        int idx = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < count[i]; j++) {
                tmp[idx] = i;
                idx++;
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
        */

        /*
        방법 2 : 투 포인터 (사실 포인트 3개)
        시간복잡도 : O(2N) -> O(N)
        공간복잡도 : O(1)
        */
        
        int left = 0, right = nums.length - 1;
        
        for(int i = 0; i <= right; i++) {
            if(nums[i] == 0) {
                swap(nums, left, i);
                left++;
            }
            
            if(nums[i] == 2) {
                swap(nums, right, i--);
                right--;
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;
    }
}