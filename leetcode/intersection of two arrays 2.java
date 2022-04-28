/*
난이도 : easy
문제 유형 : 투포인터
걸린 시간 : 15분
시간복잡도 : O(NlogN) + O(N) ==> N은 길이가 더 긴 배열의 크기
공간복잡도 : O(1)
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        List<Integer> result = new ArrayList<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int p1 = 0, p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length) {
            int n1 = nums1[p1];
            int n2 = nums2[p2];
            
            if(n1 > n2) {
                p2++;
            }
            
            if(n1 < n2) {
                p1++;
            }
            
            if(n1 == n2) {
                result.add(n1);
                p1++;
                p2++;
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}