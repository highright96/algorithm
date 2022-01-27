/*
프로그래머스 Level 2
문제 유형 : 구현
걸린 시간 : 2시간
오래걸린 이유 : 블록을 밑으로 내리는 로직(drop 메소드)에서 k >= 0 을 k > 0 으로 작성했다.
*/
class Solution {
    
    static char[][] arr;
    static boolean[][] markArr;
    static int answer = 0;
    
    public int solution(int m, int n, String[] board) {
        arr = new char[m][n];
        
        for(int i = 0; i < m; i++){
            arr[i] = board[i].toCharArray();
        }
        
        while(true){
            markArr = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    mark(i, j, arr[i][j], m, n);
                }
            }
            
            int rCnt = remove(m, n);
            if(rCnt == 0) break;
            answer += rCnt;
            drop(m, n);
        }
        return answer;
    }
    
    static void mark(int row, int col, char c, int m, int n){
        int[] dx = {0, 0, 1, 1}, dy = {0, 1, 0, 1};
        
        for(int i = 0; i < 4; i++){
            int ny = row + dy[i];
            int nx = col + dx[i];
            if(ny >= m || nx >= n) return;
            if(arr[ny][nx] != c) return;
        }
        
        for(int i = 0; i < 4; i++){
            markArr[row + dy[i]][col + dx[i]] = true;
        }
    }
    
    static int remove(int m, int n) {
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(markArr[i][j] && arr[i][j] != 0){
                    cnt++;
                    arr[i][j] = 0;
                }
            }    
        }
        return cnt;
    }
    
    static void drop(int m, int n){
        for(int i = m - 1; i > 0; i--){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0){
                    for(int k = i - 1; k >= 0; k--){
                        if(arr[k][j] != 0){
                            arr[i][j] = arr[k][j];
                            arr[k][j] = 0;
                            break;
                        }
                    }
                }
            }    
        }
    }
}