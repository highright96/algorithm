/*
프로그래머스 Level 3
문제 유형 : 완전탐색
*/
class Solution {

    Set<String> set = new HashSet<>();
    boolean[] visited;
    String[] copy;
    
    public int solution(String[] user_id, String[] banned_id) {
        copy = new String[banned_id.length];
        visited = new boolean[user_id.length];
        comb(user_id, banned_id, new String[banned_id.length], 0);
        return set.size();   
    }
    
    private void comb(String[] user_id, String[] banned_id, String[] output, int k) {
        if(k == banned_id.length) {
            if(!check(output, banned_id)) return;
            System.arraycopy(output, 0, copy, 0, output.length);
            Arrays.sort(copy);
            set.add(Arrays.toString(copy));
            return;
        }
        
        for(int i = 0; i < user_id.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[k] = user_id[i]; 
                comb(user_id, banned_id, output, k + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean check(String[] output, String[] banned_id) {
        for(int i = 0; i < banned_id.length; i++) {
            String outputId = output[i];
            String bannedId = banned_id[i];
            
            if(outputId.length() != bannedId.length()) return false;
            
            for(int j = 0; j < bannedId.length(); j++) {
                char oc = outputId.charAt(j);
                char bc = bannedId.charAt(j);
                
                if(bc != '*' && (oc != bc)) return false;
            }
        }
        return true;
    }
}