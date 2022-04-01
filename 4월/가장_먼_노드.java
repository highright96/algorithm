/*
프로그래머스 Level 3
문제 유형 : 그래프 탐색, bfs
걸린 시간 : 24분
*/
class Solution {
    public int solution(int n, int[][] edge) {
        
        int max = 0, answer = 0;
        List<Integer>[] graph = new ArrayList[n + 1];
        boolean[] visit = new boolean[n + 1];
        
        for(int i = 1; i < graph.length; i++) graph[i] = new ArrayList<>();
        
        for(int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        // 0 : 위치 , 1 : 간선수
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        visit[1] = true;
        
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int lineCnt = node[1];
            int cnt = 0;
            
            for(int i = 0; i < graph[node[0]].size(); i++) {
                int pos = graph[node[0]].get(i);
                
                if(visit[pos]) continue;
                
                q.offer(new int[]{pos, lineCnt + 1});
                visit[pos] = true;
                cnt++;
            }
            
            if(cnt == 0) {
                if(max == lineCnt) answer++;
                else if(max < lineCnt) {
                    max = lineCnt;
                    answer = 1;
                }
            }
        }
        
        return answer;
    }
}