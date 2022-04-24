/*
난이도 : medium
문제 유형 : 시뮬레이션
걸린 시간 : 20분
*/
class Solution {
    public void rotate(int[][] matrix) {
        
        int len = matrix.length;
        int[][] tmp = new int[len][len];
        
        for(int y = 0; y < len; y++) {
            for(int x = 0; x < len; x++) {
                tmp[x][len - y - 1] = matrix[y][x];
            }
        }
        
        for(int y = 0; y < len; y++) {
            for(int x = 0; x < len; x++) {
                matrix[y][x] = tmp[y][x];
            }
        }
    }
}