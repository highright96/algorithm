/*
프로그래머스 Leve2
문제 유형 : 자료구조
걸린 시간 : 40분
*/
class Solution {
    public int solution(int cacheSize, String[] cities) {

        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        
        if(cacheSize == 0) return cities.length * 5;
        
        for(String city : cities) {            
            city = city.toLowerCase();
            if(cache.contains(city)) {
                cache.remove(city);
                answer += 1;
            } else {
                if(cache.size() == cacheSize) {
                    cache.removeLast();
                }
                answer += 5;
            }
            cache.addFirst(city);
        }
        
        return answer;
    }
}