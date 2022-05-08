class Solution {
    public int firstUniqChar(String s) {
        
        int answer = Integer.MAX_VALUE;
        
        for(char c = 'a'; c <= 'z'; c++) {
            int first = s.indexOf(c);
            if(first != -1 && first == s.lastIndexOf(c)) {
                answer = Math.min(answer, first);
            }
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}