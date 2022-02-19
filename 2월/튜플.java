/*
프로그래머스 Level2
문제 유형 : 문자열, 구현
걸린 시간 : 35분
*/
class Solution {
    public int[] solution(String s) {
        
        Set<Integer> dup = new HashSet<>();
        String[] tuples = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(tuples, (a, b) -> {return a.length() - b.length(); });
        
        List<Integer> answer = new ArrayList<>();
        for(String tuple : tuples) {
            String[] ts = tuple.split(",");
            for(String t : ts) {
                int n = Integer.parseInt(t);
                if(!dup.contains(n)) {
                    dup.add(n);
                    answer.add(n);
                }
            }
        }
        
        int[] ans = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}