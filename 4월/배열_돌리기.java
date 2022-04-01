/*
프로그래머스 Level 3
문제 유형 : 배열, 구현
걸린 시간 : 42분
*/
class Solution {
    
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[][] arr = new int[rows + 1][columns + 1];
        int[] answer = new int[queries.length];
        
        int number = 1;
        for(int i = 1; i < rows + 1; i++) {
            for(int j = 1; j < columns + 1; j++) {
                arr[i][j] = number;
                number++;
            }
        }
        
        int n = 0;
        for(int[] query : queries) {
            int min = rotate(arr, query[0], query[1], query[2], query[3]);
            answer[n] = min;
            n++;
        }
        
        return answer;
        
    }
    
    private int rotate(int[][] arr, int x1, int y1, int x2, int y2){
        //좌 -> 우
        int tmp = arr[x1][y2];
        int min = tmp;
        
        for(int i = y2; i > y1; i--) {
            arr[x1][i] = arr[x1][i - 1];
            min = Math.min(arr[x1][i], min);
        }
        
        //하 -> 상
        for(int i = x1; i < x2; i++) {
            arr[i][y1] = arr[i + 1][y1];
            min = Math.min(arr[i][y1], min);
        }
        
        //우 -> 좌
        for(int i = y1; i < y2; i++) {
            arr[x2][i] = arr[x2][i + 1]; 
            min = Math.min(arr[x2][i], min);
        }
        
        //상 -> 하
        for(int i = x2; i > x1; i--) {
            arr[i][y2] = arr[i - 1][y2];
            min = Math.min(arr[i][y2], min);
        }
        
        arr[x1 + 1][y2] = tmp;
        
        return min;
    }
}