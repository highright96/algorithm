/*
프로그래머스 Level 2
문제 유형 : 구현
걸린 시간 : 27분
*/
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> history = new TreeMap<>();
        Map<String, Integer> total = new TreeMap<>();
        
        for(String record : records){
            String[] s = record.split(" ");
            if(s[2].equals("IN")){
                history.put(s[1], s[0]);
            }
            
            if(s[2].equals("OUT")){
                int t = getParkingTime(history.get(s[1]),s[0]);
                total.put(s[1], total.getOrDefault(s[1], 0) + t);
                history.remove(s[1]);
            }
        }
        
        for (String s : history.keySet()) {
            int t = getParkingTime(history.get(s), "23:59");
            total.put(s, total.getOrDefault(s, 0) + t);
        }
        
        int idx = 0;
        int[] answer = new int[total.size()];
        for (String s : total.keySet()) {
            answer[idx++] = getParkingFee(fees, total.get(s));
        }
        
        return answer;
    }
    
    static int getParkingTime(String s, String e){
        return toInteger(e) - toInteger(s);
    }
    
    static int toInteger(String s){
        int hour = Integer.parseInt(s.split(":")[0]);
        int minute = Integer.parseInt(s.split(":")[1]);
        return (hour * 60) + minute;
    }
    
    static int getParkingFee(int[] fees, int time){
        if(time <= fees[0]){
            return fees[1];
        }
        int t = (int) Math.ceil((double) (time - fees[0]) / fees[2]);
        return fees[1] + t * fees[3];
    }
}