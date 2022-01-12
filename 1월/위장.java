/*
프로그래머스 Level 2
문제 유형 : 해시
걸린 시간 : 22분
*/
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        for(String cloth : map.keySet()) {
            answer *= (map.get(cloth) + 1);
        }
        return answer - 1;
    }
}