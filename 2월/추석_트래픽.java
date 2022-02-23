/*
프로그래머스 Level3
문제 유형 : 구현
걸린 시간 : 1시간 15분
*/
class Solution {
    public int solution(String[] lines) {
        List<String> times = new ArrayList<>();
        
        for(String line : lines) {
            String[] arr = line.split(" ");
            int end = toMsec(arr[1]);
            int dur = parseSecond(arr[2]);
            times.add(end + " " + (end - dur + 1));
        }
        
        int answer = 0;
        for(int i = 0; i < times.size(); i++) {
            int end = Integer.parseInt(times.get(i).split(" ")[0]);
            int cnt = 1;
            for(int j = i + 1; j < times.size(); j++) {
                int start = Integer.parseInt(times.get(j).split(" ")[1]);
                if(start < end + 1000) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        
        
        return answer;
    }
    
    private int toMsec(String time) {
        String[] hms = time.split(":");
        return Integer.parseInt(hms[0]) * 1000 * 60 * 60 +
            Integer.parseInt(hms[1]) * 1000 * 60 +
            Integer.parseInt(hms[2].substring(0, 2)) * 1000 + 
            Integer.parseInt(hms[2].substring(3, 6));
    }
    
    private int parseSecond(String second) {
        second = second.substring(0, second.length() - 1);
        String[] arr = second.split("\\.");
        if(arr.length  == 1) return Integer.parseInt(arr[0]) * 1000;
        return Integer.parseInt(arr[0]) * 1000 + Integer.parseInt(arr[1]);
    }
}