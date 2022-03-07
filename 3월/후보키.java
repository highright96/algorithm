/*
프로그래머스 Level 2
문제 유형 : 조합, 비트마스크
걸린 시간 : 1시간 16분
비트마스크를 제대로 이해하지 않음, 조합을 구할때 짧은 조합부터 구하는 방식을 생각하는게 오래 걸림
다시 풀어봐야함.
*/
class Solution {

    List<Integer> keys = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int[] visited = new int[relation[0].length];
        for(int i = 1; i <= relation[0].length; i++) {
            back(relation, visited, 0, i);        
        }
        return keys.size();
    }
    
    private void back(String[][] relation, int[] visited, int depth, int cnt){
        if(cnt == 0) {
            if(uniqueness(relation, visited)) {
                StringBuilder sb = new StringBuilder();
                for(int i : visited) sb.append(i);
                int key = Integer.parseInt(sb.toString(), 2);
                if(minimality(key)) keys.add(key);
            }
            return;
        }
        
        if(depth >= relation[0].length) return;
        
        visited[depth] = 1;
        back(relation, visited, depth+1, cnt-1);
        visited[depth] = 0;
        back(relation, visited, depth+1, cnt);
    }
    
    private boolean uniqueness(String[][] relation, int[] visited){
        Set<String> dup = new HashSet<>();
        for(int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < relation[0].length; j++) {
                if(visited[j] == 1) sb.append(relation[i][j]);
            }
            if(!dup.add(sb.toString())) return false;
        }
        return true;
    }
    
    private boolean minimality(int i) {
        for(int key : keys) {
            if((key & i) == key) return false;
        }
        return true;
    }
}