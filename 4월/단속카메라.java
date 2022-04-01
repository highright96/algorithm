/*
프로그래머스 Level 3
문제 유형 : 우선순위 큐, 스택, 그리디
걸린 시간 : 40분
*/
class Solution {
    public int solution(int[][] routes) {
        
        Stack<Integer> camera = new Stack<>(); //설치한 카메라 위치를 저장
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]); //routes의 진입한 지점을 기준으로 내림차순
        
        for(int[] route : routes) {
            pq.offer(route);
        }
        
        while(!pq.isEmpty()) {
            int[] route = pq.poll();
            
            //설치한 카메라가 있는 경우
            if(!camera.isEmpty()) {
                int cameraPos = camera.peek();
                //설치한 카메라에 현재 자동차가 찍힌 경우
                if(cameraPos <= route[1] && cameraPos >= route[0]) continue;
            }

            //현재 자동차가 설치한 카메라에 찍히지 않은 경우, 진입한 지점에 카메라를 설치
            camera.push(route[0]);
        }
             
        return camera.size();
    }
}