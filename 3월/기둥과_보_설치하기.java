/*
프로그래머스 Level 3
문제 유형 : 구현
걸린 시간 : 2시간 이상
삭제할때의 조건을 구하지 못해서 2시간동안 풀다가 정답을 봄.
*/
class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        
        //범위를 벗어나는 경우를 대비해 패딩을 준다. 행과 열 모두 1씩 늘려준다.
        boolean[][][] structure = new boolean[n+3][n+3][2];
        
        for(int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0]+1;
            int y = build_frame[i][1]+1;
            
            //삭제
            if(build_frame[i][3] == 0) {
                delete(structure, x, y, build_frame[i][2]);
            } else {
                //기둥
                if(build_frame[i][2] == 0){
                    structure[y][x][0] = checkPilar(structure, x, y);
                }else {
                    structure[y][x][1] = checkBow(structure, x, y);
                }
            }
        }
        
        List<int[]> result = new ArrayList<>();
        //y 좌표 오름차순, x 좌표 오름차순, 기둥 > 보
        for(int i = 0; i < structure.length; i++) {
            for(int j = 0; j < structure.length; j++) {
                if(structure[j][i][0]) result.add(new int[]{i-1, j-1, 0});
                if(structure[j][i][1]) result.add(new int[]{i-1, j-1, 1});
            }
        }
        
        int[][] answer = new int[result.size()][3];
        for(int i = 0; i < result.size(); i++) {
            for(int j = 0; j < 3; j++) {
                answer[i][j] = result.get(i)[j];
            }
        }
        
        return answer;
    }

    private void delete(boolean[][][] structure, int x, int y, int type) {
        structure[y][x][type] = false;
        for(int i = 1; i < structure.length - 1; i++) {
            for(int j = 1; j < structure.length - 1; j++) {
                //기둥이 존재할 수 없는 위치면
                if(structure[i][j][0] && !checkPilar(structure, j, i)) {
                    structure[y][x][type] = true;
                    return;
                }
                //보가 존재할 수 없는 위치면
                if(structure[i][j][1] && !checkBow(structure, j, i)) {
                    structure[y][x][type] = true;
                    return;
                }
            }
        }
    }

    private boolean checkBow(boolean[][][] structure, int x, int y) {
        if(structure[y][x-1][1] && structure[y][x+1][1]) return true;
        if(structure[y-1][x][0] || structure[y-1][x+1][0]) return true;
        return false;
    }

    private boolean checkPilar(boolean[][][] structure, int x, int y){
        if(y == 1) return true;
        if(structure[y][x][1] || structure[y][x-1][1]) return true;
        if(structure[y-1][x][0]) return true;
        return false;
    }
}