/*
프로그래머스 Level 2
문제 유형 : 해쉬, 문자열, 구현
걸린 시간 : 55분
*/
class Solution {
    public String solution(String m, String[] musicinfos) {
        
        Map<String, String> music = new LinkedHashMap<>();
        int maxPlayTime = 0;
        String answer = "";
        m = comp(m);
        
        for(String musicinfo : musicinfos) {
            String[] s = musicinfo.split(",");         
            String melody = getMelody(s[0], s[1], s[3]);
            music.put(melody, s[2]);
        }

        for(String key : music.keySet()){
            int melodyLen = key.length();
            if(melodyLen >= m.length() && key.contains(m)) {
                if(maxPlayTime < melodyLen) {
                    maxPlayTime = melodyLen;
                    answer = music.get(key);
                }
            }
        }
        
        return maxPlayTime == 0 ? "(None)" : answer;
    }
    
    static String getMelody(String startTime, String endTime, String melody) {
        int playTime = getPlayTime(startTime, endTime);
        StringBuilder sb = new StringBuilder();
        melody = comp(melody);
        int idx = 0;
        while(playTime > 0) {
            idx %= melody.length();
            sb.append(melody.charAt(idx));
            playTime--;
            idx++;
        }
        return sb.toString();
    }
    
    static int getPlayTime(String startTime, String endTime){
        int startHour = Integer.parseInt(startTime.split(":")[0]);
        int startMinute = Integer.parseInt(startTime.split(":")[1]);
        int endHour = Integer.parseInt(endTime.split(":")[0]);
        int endMinute = Integer.parseInt(endTime.split(":")[1]);
        return (60 * endHour + endMinute) - (60 * startHour + startMinute); 
    }
    
    static String comp(String melody) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < melody.length(); i++) {
            char c = melody.charAt(i);
            if(c == '#') {
                char last = sb.charAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                sb.append(Character.toLowerCase(last));
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}