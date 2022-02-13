/*
프로그래머스 Level2
문제 유형 : 문자열, 구현
걸린 시간 : 50분
*/
class Solution {
    public String[] solution(String[] files) {
        
        List<String> ans = new ArrayList<>();
        
        for(String file : files) {
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            for(int i = 0; i < file.length(); i++) {
                char c = file.charAt(i);
                if(flag && Character.isDigit(c)) {
                    sb.append('/');
                    flag = false;
                }
                
                if(!flag && !Character.isDigit(c)) {
                    sb.append('/');
                    sb.append(file.substring(i, file.length()));
                    break;
                }
                sb.append(c);
            }
            ans.add(sb.toString());
        }
        
        Collections.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] sp1 = s1.split("/");
                String[] sp2 = s2.split("/");
                int interval = sp1[0].toUpperCase().compareTo(sp2[0].toUpperCase());
                
                if(interval == 0) {
                    return Integer.parseInt(sp1[1]) - Integer.parseInt(sp2[1]);
                }
                return interval;
            }
        });
        
        String[] answer = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i).replace("/", "");
        }
        return answer;
    }
}