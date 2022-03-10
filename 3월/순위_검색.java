/*
프로그래머스 Level2
문제 유형 : 조합, 이분탐색, 문자열, 구현
걸린 시간 : 1시간 40분
*/
class Solution {
    
    Map<String, ArrayList<Integer>> infoMap = new TreeMap<>();
    
    public int[] solution(String[] info, String[] query) {

        for(String s : info) {
            String[] arr = s.split(" ");
            comb("", arr, 0);
        }
        
        for(String key : infoMap.keySet()) {
        	List<Integer> scoreList = infoMap.get(key);
        	Collections.sort(scoreList);
        }
        
        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] arr = query[i].split(" ");
            answer[i] = search(arr[0], Integer.parseInt(arr[1]));
        }
        return answer;
    }
    
    private void comb(String output, String[] arr, int depth) {
        if(depth == 4) {
            if(!infoMap.containsKey(output)) {
                ArrayList<Integer> in = new ArrayList<>();
                in.add(Integer.parseInt(arr[4]));
                infoMap.put(output, in);
                return;
            }
            infoMap.get(output).add(Integer.parseInt(arr[4]));
            return;
        }
        
        comb(output+"-", arr, depth + 1);
        comb(output + arr[depth], arr, depth + 1);
    }
    
    private int search(String key, int score) {
        if(!infoMap.containsKey(key)) return 0;
        
        List<Integer> scoreList = infoMap.get(key);
        int l = 0, r = scoreList.size() - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(scoreList.get(mid) < score) l = mid + 1;
            else r = mid - 1;
        }
        
        return scoreList.size() - l;
    }
}