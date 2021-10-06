class Solution {
    
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    static int ans = 0;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        back(numbers, "");
        return ans;
    }
    
    public static void back(String numbers, String s){
        if(!s.isEmpty()){
            ans += isPrime(Integer.parseInt(s)) ? 1 : 0;
        }
        for(int i = 0; i<numbers.length(); i++){
            if(!visited[i]){
            visited[i] = true;
            s += numbers.charAt(i);
            back(numbers, s);
            visited[i] = false;
            s = s.substring(0, s.length()-1);
            }
        }
    }
    public static boolean isPrime(int n){
        if(set.contains(n) || n == 0 || n == 1){
            return false;
        } else {
            for(int i = 2; i<= Math.sqrt(n); i++){
                if(n % i == 0){
                    return false;
                }
            }
            set.add(n);
        }
        return true;
    }
}