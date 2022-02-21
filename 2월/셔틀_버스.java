/*
프로그래머스 Level3
문제 유형 : 구현
걸린 시간 : 55분
*/
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        List<Integer> times = new ArrayList<>();
        
        for(String time : timetable) {
            times.add(toMinute(time));
        }
        times.sort(null);
        
        int capacity = 0;
        int busMinute = toMinute("09:00");
        //운행수만큼 반복
        while(n > 0) {
            capacity = m;
            int maxMinute = Integer.MIN_VALUE;
            List<Integer> bus = new ArrayList<>();

            for(int i = 0; i < times.size(); i++) {
                int time = times.get(i);
                if(capacity == 0) break;
                if(busMinute >= time) {
                    maxMinute = Math.max(time, maxMinute);
                    bus.add(time);
                    times.set(i, Integer.MAX_VALUE);
                    capacity--;
                }
            }
            
            //마지막 운행인 경우(버스에는 사람들이 타 있음)
            if(n == 1) {
                //버스에 자리가 남아있는 경우
                if(capacity > 0) {
                    answer = toHour(busMinute);
                }
                
                //버스에 자리가 남아있지 않은 경우
                if(capacity == 0) {
                    answer = toHour(maxMinute - 1);
                }
            }
            
            //다음 버스 도착 시간
            busMinute += t;
            //운행 수를 줄임
            n--;
        }
        
        return answer;
    }
    
    private int toMinute(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
    
    private String toHour(int minute) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", minute / 60));
        sb.append(":");
        sb.append(String.format("%02d", minute % 60));
        return sb.toString();
    }
}