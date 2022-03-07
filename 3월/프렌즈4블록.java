/*
프로그래머스 Level 2
문제 유형 : 구현, 배열
걸린 시간 : 47분
if(c == '0') continue 조건을 찾는데 20분정도 걸림.
*/
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
                
                //왼쪽 위
                if(c == arr[i-1][j] && c == arr[i][j-1] && c == arr[i-1][j-1]) {
                    delete[i][j] = delete[i-1][j] = delete[i][j-1] = delete[i-1][j-1] = true;
                }
                
                //오른쪽 위
                if(c == arr[i-1][j] && c == arr[i-1][j+1] && c == arr[i][j+1]) {
                    delete[i][j] = delete[i-1][j] = delete[i-1][j+1] = delete[i][j+1] = true;
                }
                
                //왼쪽 아래
                if(c == arr[i][j-1] && c == arr[i+1][j-1] && c == arr[i+1][j]) {
                    delete[i][j] = delete[i][j-1] = delete[i+1][j-1] = delete[i+1][j] = true;
                }
                
                //오른쪽 아래
                if(c == arr[i][j+1] && c == arr[i+1][j] && c == arr[i+1][j+1]) {
                    delete[i][j] = delete[i][j+1] = delete[i+1][j] = delete[i+1][j+1] = true;
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