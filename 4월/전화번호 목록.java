/*
프로그래머스 Level 2
문제 유형 : 문자열
걸린 시간 : 5분
*/
class Solution {
    public boolean solution(String[] phone_book) {
 
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length - 1; i++) {
            
            if(phone_book[i + 1].startsWith(phone_book[i])) return false;
            
        }

        return true;
    }
}