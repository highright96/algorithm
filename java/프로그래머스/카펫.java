class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = new int[2];
        int g = yellow, s = 1;
        while(g >= s){
            if(yellow % g == 0){
                int b = (g * 2) + (s * 2) + 4;
                if(b == brown){
                    ans[0] = g + 2;
                    ans[1] = s + 2;
                    break;
                }
            }
            g--;
            s = yellow / g;
        }
        return ans;
    }
}