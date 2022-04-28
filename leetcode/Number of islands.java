/*
난이도 : medium
문제 유형 : DFS/BFS
걸린 시간 : 15분
*/

/*
BFS
시간복잡도 : 
공간복잡도 : 
*/
class Solution {
    
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    Queue<int[]> q = new LinkedList<>(); // y, x 저장
    boolean[][] visit;
    
    public int numIslands(char[][] grid) {
        
        visit = new boolean[grid.length][grid[0].length];
        int answer = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && !visit[i][j]) {
                    bfs(grid, i, j);
                    answer++;            
                }
            }
        }
        
        return answer;
    }
    
    private void bfs(char[][] grid, int y, int x) {
        visit[y][x] = true;
        q.offer(new int[]{y, x});
        
        while(!q.isEmpty()) {
            int[] node = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int ny = node[0] + dy[i];
                int nx = node[1] + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= grid.length || nx >= grid[0].length) continue;
                if(grid[ny][nx] == '0') continue;
                if(visit[ny][nx]) continue;
                
                visit[ny][nx] = true;
                q.offer(new int[]{ny, nx});
            }
        }
    }
}

/*
DFS
시간복잡도 : O(N)  N은 grid 배열의 크기
공간복잡도 : O(1)
*/
class Solution {
    
    public int numIslands(char[][] grid) {
        
        int answer = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    answer++;            
                }
            }
        }
        
        return answer;
    }
    
    private void dfs(char[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
        if(grid[row][col] == '0') return;
        
        
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row - 1, col);
        dfs(grid, row, col - 1);
    }
}