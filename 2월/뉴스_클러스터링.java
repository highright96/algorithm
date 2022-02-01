/*
프로그래머스 Level 2
문제 유형 : 해쉬, 문자열, 구현
걸린 시간 : 40분
*/
class Solution {
    
    static int NUMBER = 65536;
    static int uni = 0, is = 0; 
    
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new TreeMap<>();
        Map<String, Integer> map2 = new TreeMap<>();
        
        split(map1, str1);
        split(map2, str2);
        search(map1, map2);
        
        if(is == uni) {
            return NUMBER;
        }
        
        return (int) ((double) is / uni * NUMBER);
    }
    
    static void split(Map<String, Integer> map, String str){
        int n = str.length();
        for(int i = 0; i < n - 1; i++){
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if(isAlpah(c1) && isAlpah(c2)) {
                String tmp = Character.toString(c1) + Character.toString(c2);
                tmp = tmp.toLowerCase();
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }
    }
    
    static boolean isAlpah(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    
    static void search(Map<String, Integer> map1, Map<String, Integer> map2) {
        for (String key : map1.keySet()) {
            int cnt1 = map1.get(key);
            int cnt2 = map2.getOrDefault(key, 0);
            if(cnt2 == 0) uni += cnt1;
            if(cnt2 != 0) {
                is += Math.min(cnt1, cnt2);
                uni += Math.max(cnt1, cnt2);
            }
        }
        
        for (String key : map2.keySet()) {
            int cnt1 = map1.getOrDefault(key, 0);
            int cnt2 = map2.get(key);
            if(cnt1 == 0) uni += cnt2;
        }
    }
}