/*
프로그래머스 Level2
문제 유형 : BFS
걸린 시간 : 1시간 6분
전보다 더 오래걸림 -> visited 배열을 초기화하지 않았음.
*/
class Solution {
    
    int[] dy = {0,0,-1,1};
    int[] dx = {-1,1,0,0};
    boolean[][] visited;
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[places.length];
        
        for(int i = 0; i < 5; i++) {
            int result = 1;
            char[][] place = createPlace(places[i]);
            visited = new boolean[5][5];
            for(int y = 0; y < 5; y++) {
                for(int x = 0; x < 5; x++) {
                    if(place[y][x] == 'P' && !bfs(place, x, y)) {
                        result = 0;
                        x = y = 5;
                    }
                }
            }
            answer[i] = result;
        }
        return answer;
    }
    
    private char[][] createPlace(String[] place) {
        char[][] tmp = new char[5][5];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                char c = place[i].charAt(j);
                tmp[i][j] = c;
            }
        }
        return tmp;
    }
    
    private boolean bfs(char[][] place, int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[y][x] = true;
        
        while(!q.isEmpty()) {
            Node nNode = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + nNode.x;
                int ny = dy[i] + nNode.y;
                
                if(nx < 0 || ny < 0 || nx >= 5 || ny >=5) continue;
                if(visited[ny][nx]) continue;
                if(place[ny][nx] == 'X') continue;
                
                int distance = getDistance(x, y, nx, ny);
                
                if(place[ny][nx] == 'P' && distance <= 2) return false;
                else if(place[ny][nx] == 'O'){
                    if(distance >= 2) continue;
                    visited[ny][nx] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return true;
    }
    
    private int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    
    class Node {
        int x, y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}