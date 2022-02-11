/*
프로그래머스 Level 2
문제 유형 : 조합, 비트마스크
걸린 시간 : 2시간 이상
*/
class Solution {
    
    static List<Integer> keys = new ArrayList<>();
    static int[] visited;
    
    public int solution(String[][] relation) {
        int answer = 0;
        visited = new int[relation[0].length];
        
        for(int i = 1; i <= relation[0].length; i++){
            back(relation, 0, i);            
        }
        
        return keys.size();
    }
    
    static void back(String[][] relation, int depth, int cnt) {
        if(cnt == 0) {
            check(relation);
            return;
        }
        
        if(depth >= relation[0].length) return;
        
        visited[depth] = 1;
        back(relation, depth + 1, cnt - 1);
        visited[depth] = 0;
        back(relation, depth + 1, cnt);
    }
    
    static void check(String[][] relation) {
        Set<String> dup = new HashSet<>();
        StringBuilder keyIdxSb = new StringBuilder();
        
        for(int i = 0; i < visited.length; i++) {
            keyIdxSb.append(visited[i]);
        }        
        
        for(int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < relation[0].length; j++) {
                if(visited[j] == 1) sb.append(relation[i][j]);
            }
            if(!dup.add(sb.toString())) return;
        }
        
        int keyIdx = Integer.parseInt(keyIdxSb.toString(), 2);
        if(!minimality(keyIdx)) return;
        
        keys.add(keyIdx);
    }
    
    static boolean minimality(int i) {
        for (int k : keys) {
            if ((k & i) == k) return false;
        }
        return true;
    }
}