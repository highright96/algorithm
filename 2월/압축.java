/*
프로그래머스 Level2
문제 유형 : 해쉬, 문자열, 구현
걸린 시간 : 45분
*/
class Solution {
    public int[] solution(String msg) {
        
        Map<String, Integer> map = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        
        for(int i = 97; i <= 122; i++) {
            String s = Character.toString((char) i).toUpperCase();
            map.put(s, i - 96);
        }
        
        for (int i = 0; i < msg.length(); i++) {
            int depth = i + 1;
            while (true) {
                String prevSub = msg.substring(i, depth);
                if (depth >= msg.length()) {
                    output.add(map.get(prevSub));
                    i = depth;
                    break;
                }
                String sub = msg.substring(i, depth + 1);
                if (map.containsKey(sub)) {
                    depth++;
                } else {
                    map.put(sub, map.size() + 1);
                    output.add(map.get(prevSub));
                    i = depth - 1;
                    break;
                }
            }
        }
        
        int[] answer = new int[output.size()];
        for(int i = 0; i < output.size(); i++) {
            answer[i] = output.get(i);
        }
        return answer;
    }
}