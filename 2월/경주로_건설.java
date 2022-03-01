/*
프로그래머스 Level 3
문제 유형 : 그래프 탐색
걸린 시간 : 2시간 이상
테스트케이스 25번에서 1시간 넘게 걸림. 3차원 배열을 사용해 같은 방향에서 온 경로끼리 방문처리를 해줘야함.
*/
class Solution {
    //좌, 우, 상, 하
    int[] dy = {0, 0, -1, 1};
    int[] dx = {-1, 1, 0, 0};
    int answer = Integer.MAX_VALUE;
    boolean[][][] visited;
    int[][] history;
    
    public int solution(int[][] board) {
        int tx = board[0].length, ty = board.length;
        visited = new boolean[ty][tx][4];
        history = new int[ty][tx];
        bfs(board, new Node(0, -1, 0, 0), tx, ty);
        
        return answer;
    }
    
    private void bfs(int[][] board, Node node, int tx, int ty) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visited[node.y][node.x][0] = visited[node.y][node.x][1] = visited[node.y][node.x][2] =visited[node.y][node.x][3] = true;
        
        while(!queue.isEmpty()) {
            Node prev = queue.poll();
            
            if(prev.x == tx - 1 && prev.y == ty - 1) {
                answer = Math.min(prev.price, answer);
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int price = 0;
                int nx = dx[i] + prev.x;
                int ny = dy[i] + prev.y;
                
                if(nx < 0 || nx >= tx || ny < 0 || ny >= ty) continue;
                if(board[ny][nx] == 1) continue;

                if(prev.dir == -1 || prev.dir == i) price = 100;
                else price = 600;
                
                Node cur = new Node(prev.price + price, i, nx, ny);
                
                if(!visited[ny][nx][i] || cur.price <= history[ny][nx]) { 
                    visited[ny][nx][i] = true;
                    history[ny][nx] = cur.price;
                    queue.offer(cur);
                }
            }
        }
    }
    
    class Node {
        int price, dir, x, y;
        
        public Node(int price, int dir, int x, int y) {
            this.price = price;
            this.dir = dir;
            this.x = x;
            this.y = y;
        }
    }
}