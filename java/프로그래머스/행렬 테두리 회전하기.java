class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows+1][columns+1];
        int cnt = 1;
        int[] ans = new int[queries.length];
        
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                board[i][j] = cnt;
                cnt++;
            }
        }
            
        for(int i = 0; i<queries.length; i++) {
            int min = rotation(board, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
            ans[i] = min;
        }
        return ans;
    }
    
    static int rotation(int[][] board, int x1, int y1, int x2, int y2){
        int min = Integer.MAX_VALUE;
        int tmp = board[x1][y1];
        for(int i = x1; i < x2; i++){
            board[i][y1] = board[i+1][y1];
            min = Math.min(min, board[i+1][y1]);
        }
        for(int i = y1; i < y2; i++){
            board[x2][i] = board[x2][i+1];
            min = Math.min(min, board[x2][i+1]);
        }
        for(int i = x2; i > x1; i--){
            board[i][y2] = board[i-1][y2];
            min = Math.min(min, board[i-1][y2]);
        }
        for(int i = y2; i > y1; i--){
            board[x1][i] = board[x1][i-1];
            min = Math.min(min, board[x1][i-1]);
        }
        board[x1][y1+1] = tmp;
        min = Math.min(min, tmp);
        return min;
    }
}