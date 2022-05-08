class Solution {
    public boolean isAnagram(String s, String t) {
     
        if(s.length() != t.length()) return false;
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        return new String(sArr).equals(new String(tArr));
    }
}