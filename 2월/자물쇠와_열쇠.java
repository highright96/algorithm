/*
프로그래머스 Level3
문제 유형 : 시뮬레이션, 배열
걸린 시간 : 2시간 이상
*/
class Solution {
    
    int[][] board;
    int holeCnt = 0;
    
    public boolean solution(int[][] key, int[][] lock) {
        
        int lockLen = lock.length, keyLen = key.length;
        board = new int[lockLen + keyLen * 2 - 2][lockLen + keyLen * 2 - 2];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = 2;
            }
        }
        
        for(int i = 0; i < lockLen; i++) {
            for(int j = 0; j < lockLen ; j++) {
                if(lock[i][j] == 0) holeCnt++;
                board[i + keyLen - 1][j + keyLen - 1] = lock[i][j];
            }
        }
        
        for(int i = 0; i <= board.length - keyLen; i++) {
            for(int j = 0; j <= board.length - keyLen; j++) {
                for(int k = 0; k < 4; k++) {
                    if(isMatch(key, i, j)) return true;
                    key = rotate(key);
                }
            }
        }
        return false;
    }
    
    private boolean isMatch(int[][] key, int plusY, int plusX) {
        int cnt = 0;
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                if(key[i][j] == 1 && board[i + plusY][j + plusX] == 1) return false;
                if(key[i][j] == 0 && board[i + plusY][j + plusX] == 0) return false;
                if(key[i][j] == 1 && board[i + plusY][j + plusX] == 0) cnt++;
            }
        }
        return holeCnt == cnt;
    }
    
    private int[][] rotate(int[][] key) {
        int n = key.length;
        int[][] tmp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[i][j] = key[j][n - 1 - i];
            }
        }
        return tmp;
    }
}