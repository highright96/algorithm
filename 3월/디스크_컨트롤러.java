/*
프로그래머스 Level 3
문제 유형 : 구현, 힙, 우선순위 큐
걸린 시간 : 실패
*/
class Solution {
    
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int time = 0; //작업이 완료된 후의 시간
        int answer = 0;
        int jobCnt = 0; //완료한 작업
        int jobsLen = jobs.length;
        int jobsIdx = 0; //큐에 넣어줘야하는 작업 인덱스
        
        //모든 작업이 완료할 때까지 반복
        while(jobCnt < jobsLen) {
            
            //하나의 작업이 완료되는 시점(jobsIdx) 전에 시작할 수 있는 작업을 큐에 넣음
            while(jobsIdx < jobsLen && jobs[jobsIdx][0] <= time) {
                pq.offer(jobs[jobsIdx]);
                jobsIdx++;
            }
            
            //큐가 비어있다면 작업 완료 이후에 다음 작업이 들어온다는 의미
            if(pq.isEmpty()) {
                time = jobs[jobsIdx][0];
                
            //작업이 끝나기 전에 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
            } else {
                int[] job = pq.poll();
                answer += job[1] + time - job[0];
                //작업이 끝나는 시간은 이전 작업이 완료된 시간(time) + 현재 작업의 수행시간
                time += job[1];
                jobCnt++;
            }
        }

        return answer / jobsLen;
    }
}