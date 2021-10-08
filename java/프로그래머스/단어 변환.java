class Solution {
    
    static ArrayList<Integer>[] graph;
    static int min = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        graph = new ArrayList[words.length];
        for(int i = 0; i<words.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<words.length; i++){
            for(int j = 0; j<words.length; j++){
                if(i != j && isChange(words[i], words[j])){
                    graph[i].add(j);
                }
            }
        }
        
        for(int i = 0; i<graph.length; i++){
            if(isChange(begin, words[i])){
                bfs(i, target, words);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public static void bfs(int idx, String target, String[] words){
        boolean[] visited = new boolean[50];
        Queue<Point> queue = new LinkedList<>();
        visited[idx] = true;
        queue.add(new Point(idx, 1));
        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(words[p.idx].equals(target)){
                min = Math.min(min, p.cnt);
                return;
            }
            for(int i : graph[p.idx]){
                if(!visited[i]){
                    queue.add(new Point(i, p.cnt + 1));
                    visited[i] = true;
                }
            }
        }
    }
    
    public static boolean isChange(String s1, String s2){
        int cnt = 0;
        if(s1.length() != s2.length()){
            return false;
        }
        for(int i = 0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                cnt++;
            }
            if(cnt > 1){
                return false;
            }
        }
        return true;
    }
    
    static class Point {
        int idx;
        int cnt;
        
        public Point(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}