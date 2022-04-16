import java.util.*;
/*
프로그래머스 Level 2
문제 유형 : 큐
걸린 시간 : 1시간
*/
class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int time = 0, idx = 0, len = truck_weights.length;
        Queue<Integer> q = new LinkedList<>();
        
        while(idx < len) {
            
            //다리가 꽉찬 경우
            if(q.size() == bridge_length) {
                weight += q.poll();
            } 
            //다리가 꽉차지 않은 경우
            else {
                int w = truck_weights[idx];
                
                //다리에 트럭을 넣을 수 있는 경우
                if(w <= weight) {
                    q.offer(w);
                    weight -= w;
                    time++;
                    idx++;
                } 
                //다리에 트럭을 넣을 수 없는 경우
                else {
                    q.offer(0);
                    time++;
                }
            }
        }
        
        //마지막 트럭이 다리를 지나는 시간을 더해준다.
        return time + bridge_length;
    }
}