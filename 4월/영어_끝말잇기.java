/*
프로그래머스 Level 2
문제 유형 : 문자열
걸린 시간 : 10분
*/
class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> usedWords = new HashSet<>();
        int count = 1, number = 0, order = 0;
        boolean flag = true;
        
        usedWords.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            String prev = words[i - 1], cur = words[i];
            count++;
            
            if(!usedWords.add(cur) || prev.charAt(prev.length() - 1) != cur.charAt(0)) {
                flag = false;
                break;
            }
        }
        
        if(flag) return new int[]{0, 0};
        
        int tmp = count % n;
        number = tmp == 0 ? n : tmp;
        order = (int) Math.ceil((double) count / n);
        
        return new int[]{number, order};
    }
}