/*
프로그래머스 Level 2
문제 유형 : 해쉬
걸린 시간 : 13분
*/
class Solution {
    public boolean solution(String[] phone_book) {
        
        Set<String> phone = new HashSet<>();
        for(String number : phone_book){
            phone.add(number);
        }
        
        for(String number : phone_book){
            phone.remove(number);
            for(int i = 0; i<number.length(); i++){
                String piece = number.substring(0, i+1);
                if(phone.contains(piece)){
                    return false;
                }
            }
            phone.add(number);
        }
        return true;
    }
}