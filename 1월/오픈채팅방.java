/*
프로그래머스 Level 2
걸린 시간 : 24분
*/
class Solution {
    public String[] solution(String[] records) {
        Map<String, String> names = new HashMap<>();
        List<String> answer = new ArrayList<>();
        
        for(String record : records){
            String[] s = record.split(" ");
            if(!s[0].equals("Leave")){
                names.put(s[1], s[2]);
            }
        }
        
        for(String record : records){
            StringBuilder sb = new StringBuilder();
            String[] s = record.split(" ");
            if(s[0].equals("Enter")) {
                sb.append(names.get(s[1])).append("님이 들어왔습니다.");
                answer.add(sb.toString());
            }
            if(s[0].equals("Leave")){
                sb.append(names.get(s[1])).append("님이 나갔습니다.");
                answer.add(sb.toString());
            }
        }
        
        String[] ans = new String[answer.size()];
        for(int i = 0; i<answer.size(); i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}