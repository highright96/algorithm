/*
난이도 : medium
문제 유형 : 투포인터, 이분탐색
걸린 시간 : 40분
*/
class Solution {
    public int findDuplicate(int[] nums) {
        
        int low = 1, high = nums.length - 1;
        
        while(low < high) {
            
            int mid = (low + high) / 2;
            
            int count = 0;
            for(int num : nums) {
                if(num <= mid) {
                    count++;
                }
            }
            
            if(count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}