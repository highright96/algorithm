class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        back(0, 0, numbers, target);
        return answer;
    }
    
    public static void back(int cnt, int sum, int[] arr, int target){
        if(cnt == arr.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        back(cnt+1, sum - arr[cnt], arr, target);
        back(cnt+1, sum + arr[cnt], arr, target);
    }
}