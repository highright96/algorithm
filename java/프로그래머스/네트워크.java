class Solution {
    
    static boolean[] visited = new boolean[200];
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i = 0; i<computers.length; i++){
            if(!visited[i]){
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    static void dfs(int idx, int[][] arr){
        visited[idx] = true;
        for(int i = 0; i<arr[idx].length; i++){
            if(!visited[i] && arr[idx][i] == 1){
                dfs(i, arr);
            }
        }
    }
}