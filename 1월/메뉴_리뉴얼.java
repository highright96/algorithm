/*
프로그래머스 Level 2
문제 유형 : 백트래킹
걸린 시간 : 1시간 30분
*/
class Solution {
    
    static Map<String, Integer> map = new TreeMap<>();
    static int[] maxCount = new int[11];
    
    public String[] solution(String[] orders, int[] course) {

        List<String> tmp = new ArrayList<>();
        
        for(String order : orders) {
            boolean[] visited = new boolean[order.length()];
            back(visited, order, 0);
        }
        
        for (String s : map.keySet()) {
            int v = map.get(s);
            if(v >= maxCount[s.length()]){
                maxCount[s.length()] = v;
            }
        }
        
        for (String s : map.keySet()) {
            int v = map.get(s);
            for(int n : course) {
                if(n == s.length() && v >= 2 && v == maxCount[s.length()]) {
                    tmp.add(s);
                }
            }
        }
        
        String[] answer = new String[tmp.size()];
        for(int i = 0; i < tmp.size(); i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    }
    
    static void back(boolean[] visited, String order, int depth) {
        if(depth == order.length()) {
            PriorityQueue<Character> pq = new PriorityQueue<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    pq.offer(order.charAt(i));
                }
            }
            
            while(!pq.isEmpty()) {
                sb.append(pq.poll());
            }
            
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        visited[depth] = true;
        back(visited, order, depth+1);
        visited[depth] = false;
        back(visited, order, depth+1);
    }
}