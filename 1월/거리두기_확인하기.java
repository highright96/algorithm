/*
프로그래머스 Level 2
문제 유형 : BFS
걸린 시간 : 50시간
*/
class Solution {
    
    static boolean isChk;
    static Queue<Postion> pq;
    static char[][] place;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i<5; i++) {
            pq = new LinkedList<>();
            isChk = false;
            place = createPlace(places, i);
            while(!pq.isEmpty()){
                Postion p = pq.poll();
                bfs(p.y, p.x);
                if(isChk) break;
            }
            answer[i] = isChk ? 0 : 1;
        }
            
        return answer;
    }
    
    static void bfs(int y, int x){
        int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
        Queue<Postion> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        q.offer(new Postion(y, x));
        visited[y][x] = true;
        while(!q.isEmpty()){
            Postion p = q.poll();
            for(int i = 0; i<4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
            
                if(ny < 0 || nx < 0 || ny > 4 || nx > 4 || visited[ny][nx]) continue;
                if(place[ny][nx] == 'X') continue;
                if((place[ny][nx] == 'O' || place[ny][nx] == 'P') && cal(y, x, ny, nx) > 2) {
                    continue;
                }
                if(place[ny][nx] == 'P' && cal(y, x, ny, nx) <= 2) {
                    isChk = true;
                    return;
                }
                visited[ny][nx] = true;
                q.offer(new Postion(ny, nx));
            }
        }
    }
        
    static char[][] createPlace(String[][] places, int start){
        char[][] place = new char[5][5];
        for(int i = 0; i < 5; i++){
            String s = places[start][i];
            for(int j = 0; j < 5; j++){
                char c = s.charAt(j);
                place[i][j] = c;
                if(c == 'P'){
                    pq.offer(new Postion(i, j));
                }
            }
        }
        return place;
    }
    
    static int cal(int y, int x, int ny, int nx){
        return Math.abs(x - nx) + Math.abs(y - ny);
    }
    
    static class Postion {
        int y;
        int x;
        
        Postion(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}