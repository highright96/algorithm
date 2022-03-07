class Solution {
    
    char[][] arr;
    boolean[][] delete;
    
    public int solution(int m, int n, String[] board) {
        
        arr = new char[m+2][n+2];
        
        //범위를 벗어나는 경우를 위해 패딩을 준다.
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                arr[i+1][j+1] = board[i].charAt(j);
            }
        }
        
        while(true) {
            delete = new boolean[m+2][n+2];
            check();
            if(!bomb()) break;
            down();  
        }
        
        int answer = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == '0') answer++;
            }
        }
        
        return answer;
    }
    
    private void check() {
        for(int i = 1; i < arr.length - 1; i++) {
            for(int j = 1; j < arr[i].length - 1; j++) {
                char c = arr[i][j];
                if(c == '0') continue;
                if(c == arr[i-1][j] && c == arr[i][j-1] && c == arr[i-1][j-1]) {
                    delete[i][j] = delete[i-1][j] = delete[i][j-1] = delete[i-1][j-1] = true;
                }
            }
        }
    }
    
    private boolean bomb() {
        boolean isBomb = false;
        for(int i = 1; i < arr.length - 1; i++) {
            for(int j = 1; j < arr[i].length - 1; j++) {
                if(delete[i][j]) {
                    arr[i][j] = '0';
                    isBomb = true;
                }
            }
        }
        return isBomb;
    }
    
    private void down(){
        for(int i = 1; i < arr[0].length - 1; i++) {
            for(int j = arr.length - 2; j >= 1; j--) {
                if(arr[j][i] == '0') {
                    for(int k = j-1; k>=1; k--) {
                        if(arr[k][i] != '0') {
                            arr[j][i] = arr[k][i];
                            arr[k][i] = '0';
                            break;
                        }
                    }
                }
            }
        }
    }
}