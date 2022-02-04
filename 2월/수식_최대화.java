/*
프로그래머스 Level 2
문제 유형 : 백트래킹, 문자열, 구현
걸린 시간 : 2시간
*/
class Solution {
    
    static long answer = 0;
    static List<String> exp = new ArrayList<>();
    
    public long solution(String expression) {
        Set<Character> set = new HashSet<>();
        List<Character> operators = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c < '0' || c > '9') {
                exp.add(sb.toString());
                sb = new StringBuilder();
                exp.add(Character.toString(c));
                if(!set.contains(c)){
                    set.add(c);
                    operators.add(c); 
                }
            } else sb.append(c);
            
            if(i == expression.length() - 1) exp.add(sb.toString());
        }
        
        back(operators, new char[operators.size()], new boolean[operators.size()], 0);
        return answer;
    }
    
    static void back(List<Character> operators, char[] priority, boolean[] visited, int depth) {
        if(depth == operators.size()){
            answer = Math.max(answer, Math.abs(cal1(priority)));            
            return;
        }
        
        for(int i = 0; i < operators.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                priority[depth] = operators.get(i);
                back(operators, priority, visited, depth+1);
                visited[i] = false;
            }
        }
    }
    
    static long cal1(char[] priority) {
        List<String> tmp = new ArrayList<>();
        tmp.addAll(0, exp);
        for(int i = 0; i < priority.length; i++) {
            String op = Character.toString(priority[i]);
            int idx = 0;
            while(idx < tmp.size()) {
                if(tmp.get(idx).equals(op)) {
                    long result = cal2(Long.parseLong(tmp.get(idx - 1)), Long.parseLong(tmp.get(idx + 1)), op);
                    tmp.set(idx - 1, String.valueOf(result));
                    tmp.remove(idx);
                    tmp.remove(idx);
                } else idx++;
            }
        }
        
        return Long.parseLong(tmp.get(0));
    }
    
    static long cal2(long num1, long num2, String operation){
        if(operation.equals("+")) return num1 + num2;
        if(operation.equals("-")) return num1 - num2;
        return num1 * num2;
    }
}