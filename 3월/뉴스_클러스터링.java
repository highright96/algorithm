/*
프로그래머스 Level 2
문제 유형 : 해쉬, 문자열, 구현
걸린 시간 : 30분
*/
class Solution {
    
    int in = 0, uni = 0;
    Map<String, Integer> map1 = new HashMap<>(); 
    Map<String, Integer> map2 = new HashMap<>(); 
    
    public int solution(String str1, String str2) {
        divide(str1, map1);
        divide(str2, map2);
        similarity();
        return calculate();
    }
    
    private void divide(String str, Map<String, Integer> map) {
        for(int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if(isAlpah(c1) && isAlpah(c2)) {
                String tmp = Character.toString(c1) + Character.toString(c2);
                tmp = tmp.toLowerCase();
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }
    }
    
    private boolean isAlpah(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    
    private void similarity() {
        for(String key : map1.keySet()) {
            int v1 = map1.get(key);
            int v2 = map2.getOrDefault(key, 0);
            in += Math.min(v1, v2);
            uni += Math.max(v1, v2);
        }
        
        for(String key : map2.keySet()) {
            int v1 = map1.getOrDefault(key, 0);
            int v2 = map2.get(key);
            if(v1 == 0) uni += Math.max(v1, v2);
        }
    }
    
    private int calculate() {
        if(map1.size() == 0 && map2.size() == 0) return 65536;
        return (int) ((double) in / uni * 65536);
    }
}