/*
프로그래머스 Level 2
문제 유형 : 구현
걸린 시간 : 28분
*/
class Solution {
    
    boolean[][][] visited = new boolean[11][11][4];
    
    public int solution(String dirs) {
        
        int x = 5, y = 5, answer = 0;
        for(int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            if(c == 'L' && x - 1 >= 0){
                if(!check(x, y, 0) && !check(x - 1, y, 1)) answer++;
                visited[y][x - 1][1] = true;
                visited[y][x][0] = true;
                x -= 1;
            } else if (c == 'R' && x + 1 <= 10) {
                if(!check(x, y, 1) && !check(x + 1, y, 0)) answer++;
                visited[y][x][1] = true;
                visited[y][x + 1][0] = true;
                x += 1;
            } else if (c == 'U' && y + 1 <= 10) {
                if(!check(x, y + 1, 2) && !check(x, y, 3)) answer++;
                visited[y + 1][x][2] = true;
                visited[y][x][3] = true;
                y += 1;
            } else if (c == 'D' && y - 1 >= 0) {
                if(!check(x, y, 2) && !check(x, y - 1, 3)) answer++;
                visited[y][x][2] = true;
                visited[y - 1][x][3] = true;
                y -= 1;
            }
        }
        
        return answer;
    }
    
    private boolean check(int x, int y, int dir) {
        return visited[y][x][dir];
    }
}