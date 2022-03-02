/*
프로그래머스 Level 3
문제 유형 : 구현, bfs
걸린 시간 : 미해결
*/
class Solution {
    int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
    int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    boolean[][] visited;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] board) {
        int N = board.length;
        visited = new boolean[N][N];
        bfs(board, new Robot(0,0,1,0,0), N);        
        return answer;
    }
    
    private void bfs(int[][] board, Robot robot, int N) {
        Queue<Robot> q = new LinkedList<>();
        q.offer(robot);
        visited[robot.ly][robot.lx] = true;
        visited[robot.ry][robot.rx] = true;
        
        while(!q.isEmpty()) {
            Robot prev = q.poll();
            
            if((prev.lx == N - 1 && prev.ly == N - 1) || (prev.rx == N - 1 && prev.ry == N - 1)) {
                answer = Math.min(answer, prev.time);
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int nlx = prev.lx + dx[i];
                int nly = prev.ly + dy[i];
                int nrx = prev.rx + dx[i];
                int nry = prev.ry + dy[i];
                
                if(nlx < 0 || nly < 0 || nrx < 0 || nry < 0 ||
                  nlx >= N || nly >= N || nrx >= N || nry >= N) continue;
                
                if(board[nly][nlx] == 1 || board[nry][nrx] == 1) continue;
                if(!visited[nly][nlx] && !visited[nry][nrx]) continue;
                
                Robot cur = new Robot(nlx, nly, nrx, nry, prev.time + 1);
                q.offer(cur);
                visited[cur.ly][cur.lx] = true;
                visited[cur.ry][cur.rx] = true;
            }
            
            if(prev.ly < N - 1 && prev.ry < N - 1 && prev.lx < N - 1 && prev.rx < N - 1) {
                if(board[prev.ly + 1][prev.lx] != 1 && board[prev.ry + 1][prev.rx] != 1) {
                    //우하
                    if(!visited[prev.ry + 1][prev.rx]) {
                        Robot cur = new Robot(prev.lx + 1, prev.ly + 1, prev.rx, prev.ry, prev.time + 1);
                        q.offer(cur);
                        visited[cur.ly][cur.lx] = true;
                    }
                    //좌하
                    if(!visited[prev.ly + 1][prev.lx]) {
                        Robot cur = new Robot(prev.lx, prev.ly, prev.rx - 1, prev.ry + 1, prev.time + 1);
                        q.offer(cur);
                        visited[cur.ry][cur.rx] = true;
                    }
                }
            }
            
            if(prev.ly > 0 && prev.ry > 0 && prev.lx > 0 && prev.rx > 0) {
                if(board[prev.ly - 1][prev.lx] != 1 && board[prev.ry - 1][prev.rx] != 1) {
                    //우상
                    if(!visited[prev.ry - 1][prev.rx]) {
                        Robot cur = new Robot(prev.lx + 1, prev.ly - 1, prev.rx, prev.ry, prev.time + 1);
                        q.offer(cur);
                        visited[cur.ly][cur.lx] = true;
                    }
                    
                    //좌상
                    if(!visited[prev.ly - 1][prev.lx]) {
                        Robot cur = new Robot(prev.lx, prev.ly, prev.rx - 1, prev.ry - 1, prev.time + 1);
                        q.offer(cur);
                        visited[cur.ry][cur.rx] = true;
                    }
                }
            }
        }
    }
    
    class Robot {
        int lx, ly, rx, ry, time;
        
        public Robot(int lx, int ly, int rx, int ry, int time) {
            this.lx = lx;
            this.ly = ly;
            this.rx = rx;
            this.ry = ry;
            this.time = time;
        }
    }
}