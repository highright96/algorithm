/*
프로그래머스 Level 3
문제 유형 : DFS
걸린 시간 : 30분
*/
class Solution {
    
    boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(i == j) continue;
                if(computers[i][j] == 0) continue;
                
                graph[i].add(j);
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;
            dfs(graph, i);
            answer++;
        }
        
        return answer;
    }
    
    private void dfs(List<Integer>[] graph, int s) {
        visit[s] = true;
        for(int i = 0; i < graph[s].size(); i++) {
            int c = graph[s].get(i);
            if(visit[c]) continue;
            dfs(graph, c);
        }
    }
}