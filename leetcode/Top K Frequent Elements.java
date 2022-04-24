/*
난이도 : medium
문제 유형 : 우선순위 큐
걸린 시간 : 25분
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        /*
        방법 1 : 우선순위 큐
        시간복잡도 : O(NlogN)
        공간복잡도 : O(N)
        */
        int[] answer = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int count = 0;
        
        Arrays.sort(nums); // O(NlogN)
        
        for(int i = 0; i < nums.length; i++) {
            
            count++;
            
            if(i == nums.length - 1) {
                pq.offer(new int[]{nums[i], count});
                break;
            }
            
            if(nums[i] != nums[i + 1]) {
                pq.offer(new int[]{nums[i], count});
                count = 0;
            }
        }
        
        int idx = 0;
        while(idx < k) {
            answer[idx] = pq.poll()[0];
            idx++;
        }
        
        return answer;
    }
}