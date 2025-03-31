import java.util.*;

class Solution {
    
    static class Wait implements Comparable<Wait> {
        int workingTime;
        int requestTime;
        int num;
        
        Wait(int workingTime, int requestTime, int num) {
            this.workingTime = workingTime;
            this.requestTime = requestTime;
            this.num = num;
        }
        
        @Override
        public int compareTo(Wait w) {
            if (this.workingTime == w.workingTime) {
                if (this.requestTime == w.requestTime) {
                    return this.num - w.num;
                } 
                return this.requestTime - w.requestTime;
            }
            return this.workingTime - w.workingTime;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Wait> pq = new PriorityQueue<>();
        int time = 0;
        int index = 0;
        int count = 0;
        int totalWaitTime = 0;
        int num = 0;
        
        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.add(new Wait(jobs[index][1], jobs[index][0], num++));
                index++;
            }
            
            if (pq.isEmpty()) {
                time = jobs[index][0];
            } else {
                Wait current = pq.poll();
                time += current.workingTime;
                totalWaitTime += time - current.requestTime;
                count++;
            }
        }
        
        answer = totalWaitTime / jobs.length;
        return answer;
    }
}
