class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int o = 0, t = 0, th = 0;
        for(int i = 0; i<answers.length; i++){
            o += one[i%one.length] == answers[i] ? 1 : 0;
            t += two[i%two.length] == answers[i] ? 1 : 0;
            th += three[i%three.length] == answers[i] ? 1 : 0;
        }

        int max = Math.max(Math.max(o, t), th);
        List<Integer> ans = new ArrayList<>();
        if(o == max){
            ans.add(1);
        }
        if (t == max){
            ans.add(2);
        }
        if(th == max){
            ans.add(3);
        }
        int[] answer = new int[ans.size()];
        for(int i = 0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}