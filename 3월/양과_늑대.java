/*
프로그래머스 Level 3
문제 유형 : 완전탐색
걸린 시간 : 1시간 34분
방문할 다음 노드를 선택할때 지금 방문한 노드의 자식뿐만 아니라 방문했던 모든 노드의 자식도 포함 -> 뒤로 가는 방법
*/
class Solution {
    
    int n, answer = 0;
    boolean[] visited;
    List<Integer>[] graph;
    
    public int solution(int[] info, int[][] edges) {
        
        n = info.length; 
        visited = new boolean[n];
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
            
        for(int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
        }
        
        visited[0] = true;
        dfs(info, 0, 0, 0);
        return answer;
    }
    
    private void dfs(int[] info, int sheep, int wolf, int idx) {
        
        if(info[idx] == 0) sheep += 1;
        else wolf+=1;
        
        if(wolf >= sheep) return;
        answer = Math.max(answer, sheep);
    
        for(int i = 0; i < n; i++) {
            //다음으로 이동할 노드는 방문한 노드들의 자식 중에 하나 선택
            if(visited[i]) {
                //자식 노드가 없는 경우
                if(graph[i].size() == 0) continue;
                
                for(int j = 0; j < 2; j++) {
                    
                    //자식 노드가 하나인 경우
                    if(j == 1 && graph[i].size() == 1) continue;
                    
                    int nIdx = graph[i].get(j);
                    if(!visited[nIdx]) {
                        visited[nIdx] = true;
                        dfs(info, sheep, wolf, nIdx);
                        visited[nIdx] = false;
                    }
                }
            }
        }
    }
}