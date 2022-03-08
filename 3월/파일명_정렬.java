
/*
프로그래머스 Level2
문제 유형 : 문자열, 구현
걸린 시간 : 45분
*/
class Solution {
    public String[] solution(String[] files) {
        
        List<File> arr = new ArrayList<>();
        
        for(String file : files) {
            int pos = 0;
            File nFile = new File();
            StringBuilder sb = new StringBuilder();
            
            //head
            while(true) {
                char c = file.charAt(pos);
                if(Character.isDigit(c)) {
                    nFile.head = sb.toString().toUpperCase();
                    break;
                }
                sb.append(c);
                pos+=1;
            }
            
            //number
            sb = new StringBuilder();
            while(true) {
                if(pos >= file.length() || !Character.isDigit(file.charAt(pos))) {
                    nFile.number = Integer.parseInt(sb.toString());
                    break;
                }
                sb.append(file.charAt(pos));
                pos+=1;
            }
            
            nFile.fullName = file;
            arr.add(nFile);
        }
        
        Collections.sort(arr);
        
        String[] answer = new String[arr.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i).fullName;
        }
        
        return answer;
    }
    
    class File implements Comparable<File> {
        String head;
        int number;
        String fullName;
        
        public File() {}
        
        @Override
        public int compareTo(File o) {
            if(this.head.compareTo(o.head) == 0) return this.number - o.number;
            return this.head.compareTo(o.head);
        }
    }
}