/*
프로그래머스 Level 3
문제 유형 : 완전탐색
걸린 시간 : 1시간 45분
*/
class Solution {

    Set<String> dup = new HashSet<>();
    String[] copy;
    
    public int solution(String[] user_id, String[] banned_id) {
        copy = new String[banned_id.length];
        comb(new boolean[user_id.length] ,new String[banned_id.length], user_id, banned_id, 0);
        return dup.size();
    }
    
    private void comb(boolean[] visited,String[] output, String[] user_id, String[] banned_id, int n) {
        if(n == banned_id.length) {
            if(!isMatched(banned_id, output)) return;
            System.arraycopy(output, 0, copy, 0, output.length);
            Arrays.sort(copy);
            dup.add(Arrays.toString(copy));
            return;
        }
        
        for(int i = 0; i < user_id.length; i++) {
            if(!visited[i]) {
                output[n] = user_id[i];
                visited[i] = true;
                comb(visited, output, user_id, banned_id, n + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean isMatched(String[] banned_id, String[] output) {
        for(int i = 0; i < output.length; i++) {
            String bannedId = banned_id[i];
            String userId = output[i];
            
            if(bannedId.length() != userId.length()) return false;
            
            for(int j = 0; j < bannedId.length(); j++) {
                char bc = bannedId.charAt(j), uc = userId.charAt(j);
                if(bc != '*' && bc != uc) return false;
            }
        }
        return true;
    }
}