/*
프로그래머스 Level 2
문제 유형 : 구현
걸린 시간 : 26분
*/
class Solution {
    
    Map<String, Integer> history = new HashMap<>();
    TreeMap<String, Integer> result = new TreeMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        
        for(String record : records) {
            String[] arr = record.split(" ");
            int minute = toMinute(arr[0]);
            
            if(arr[2].equals("IN")) {
                history.put(arr[1], minute);
            }
            if(arr[2].equals("OUT")) {
                int prevMinute = history.get(arr[1]);
                result.put(arr[1], result.getOrDefault(arr[1], 0) + minute - prevMinute);
                history.remove(arr[1]);
            }
        }

        int minute = toMinute("23:59");
        for(String key : history.keySet()) {
            int prevMinute = history.get(key);
            result.put(key, result.getOrDefault(key, 0) + minute - prevMinute);
        }
        
        int idx = 0;
        int[] answer = new int[result.size()];
        for(String key : result.keySet()) {
            int total = result.get(key);
            if(total <= fees[0]) answer[idx] = fees[1];
            else {
                int f = (int) Math.ceil((double) (total - fees[0]) / fees[2]);
                answer[idx] = fees[1] + f * fees[3];
            }
            idx++;
        }
        
        return answer;
    }
    
    private int toMinute(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}