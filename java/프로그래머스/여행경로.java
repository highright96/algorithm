class Solution {
    
    static boolean[] visited = new boolean[10000];
    static List<String> ans = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        for(int i = 0; i<tickets.length; i++){
            dfs(tickets, "ICN", "", 0);
        }
        ans.sort(null);
        return ans.get(0).split(" ");
    }
    
    public static void dfs(String[][] tickets, String cur, String path, int cnt){
        path += cur + " ";
        if(tickets.length == cnt){
            ans.add(path);
            return;
        }
        for(int i = 0; i<tickets.length; i++){
            String s = tickets[i][0], e = tickets[i][1];
            if(s.equals(cur) && !visited[i]){
                visited[i] = true;
                dfs(tickets, e, path, cnt+1);
                visited[i] = false;
            }
        }
    }
}