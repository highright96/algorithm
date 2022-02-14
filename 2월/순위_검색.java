/*
프로그래머스 Level2
문제 유형 : 조합, 이분탐색, 문자열, 구현
걸린 시간 : 실패
이유 : 이분탐색 연습이 필요함.
*/
class Solution {
    
    Map<String, ArrayList<Integer>> infoMap;
    
    public int[] solution(String[] info, String[] query) {

        int[] answer = new int[query.length];
        infoMap = new TreeMap<>();
        
        for(String inf : info) {
            comb("", inf.split(" "), 0);
        }
        
        List<String> tmpList = new ArrayList<>(infoMap.keySet());
        for(int i = 0; i < tmpList.size(); i++) {
        	List<Integer> scoreList = infoMap.get(tmpList.get(i));
        	Collections.sort(scoreList);
        }
        
       for(int i=0; i<query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] sp = query[i].split(" ");
            int score = Integer.parseInt(sp[1]);
            answer[i] = binarySearch(sp[0], score);
        }
        return answer;
    }
    
    public void comb(String output, String[] info, int depth) {
        if(depth == 4) {
            if(!infoMap.containsKey(output)) {
                ArrayList<Integer> in = new ArrayList<>();
                in.add(Integer.parseInt(info[4]));
                infoMap.put(output, in);
            } else {
                infoMap.get(output).add(Integer.parseInt(info[4]));
            }
            return;
        }
        
        comb(output + "-", info, depth + 1);
        comb(output + info[depth], info, depth + 1);
    }
    
    public int binarySearch(String target, int score) {
        if(!infoMap.containsKey(target)) return 0;
        
        List<Integer> scoreList = infoMap.get(target);
        int l = 0, r = scoreList.size() - 1;
        while(l <= r) {
            int mid = (r + l) / 2;
            if(scoreList.get(mid) < score) l = mid + 1;
            else r = mid - 1;
        }
        
        return scoreList.size() - l;
    }
}