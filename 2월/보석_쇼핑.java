/*
프로그래머스 Level3
문제 유형 : 해쉬, 투포인터
걸린 시간 : 2시간
end와 start 인덱스를 answer 배열에 넣어줄때 많이 헷갈림
*/
class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for(String gem : gems) {
            set.add(gem);
        }
        int gemKind = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        int start = 0, end = 0, minDist = Integer.MAX_VALUE;
        
        while(true) {
            if(map.size() == gemKind) {
                if(end - start < minDist) {
                    minDist = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }
                
                int afterRemoved = map.get(gems[start]) - 1;
                if(afterRemoved == 0)  {
                    map.remove(gems[start]);
                } else map.put(gems[start], afterRemoved);
                start++;
            } else if(end == gems.length) {
                break;
            } else if(map.size() < gemKind) {
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                end++;
            }
        }
        
        return answer;
    }
}