class Solution {
    
    static Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for(int c : course){
            int max = 0;
            map = new HashMap<>();
            for(String s : orders){
                char[] arr = s.toCharArray();
                Arrays.sort(arr);
                String str = String.valueOf(arr);
                if(s.length() >= c){
                    StringBuilder sb = new StringBuilder();
                    makeString(str, sb, 0, 0, c);
                }
            }
            for (String s : map.keySet()){
                max = Math.max(map.get(s), max);   
            }
            
            for (String s : map.keySet()){
                if(map.get(s) == max && max >= 2){
                    answer.add(s);
                }
            }
        }
        
        answer.sort(null);
        String[] ans = new String[answer.size()];
        for(int i = 0; i<answer.size(); i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
    
    static void makeString(String s, StringBuilder sb, int cnt, int idx, int course){
        if(course == cnt){ 
            setMap(sb.toString());
            return;
        }
        for(int i = idx; i<s.length(); i++){
            sb.append(s.charAt(i));
            makeString(s, sb, cnt+1, i+1, course);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    static void setMap(String s){
       if(map.containsKey(s)){
           map.put(s, map.get(s) + 1);
       } else {
           map.put(s, 1);
       }
    }
}