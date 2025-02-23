import java.util.*;

class Solution {
    
    static class Advice {
        int time;
        int duration;
        Advice(int time, int duration) {
            this.time = time;
            this.duration = duration;
        }
    }
    
    public int solution(int k, int n, int[][] reqs) {
        // 멘토 n 명, 1~k 상담 유형
        // 멘토 n명이 1~k 상담 중 하나만 담당
        // 참가자가 요청한 시간만큼 상담시간이 걸림
        
        // 상담 유형별로 멘토 한 명씩 배분해 준 다음에
        // 가장 많은 대기 시간을 만드는 상담 유형에 한 명씩 추가로 배분해주면 되려나
        // 근데 그렇게 하면 너무 느림..
        
        List<List<Advice>> advice = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            advice.add(new ArrayList<>());
        }
        for (int[] req : reqs) {
            int time = req[0];
            int duration = req[1];
            int type = req[2];
            advice.get(type).add(new Advice(time, duration));
        }
        
        int[] mentors = new int[k+1];
        for (int i = 1; i <= k; i++) {
            mentors[i] = 1;
        }
        
        int mentorCnt = k;
        while (mentorCnt < n) {
            int maxReduction = 0;
            int bestType = -1;
            for (int i = 1; i <= k; i++) {
                if (advice.get(i).isEmpty()) continue;
                int currentWait = calculate(advice.get(i), mentors[i]);
                int nextWait = calculate(advice.get(i), mentors[i] + 1);
                int reduction = currentWait - nextWait;
                if (reduction > maxReduction) {
                    maxReduction = reduction;
                    bestType = i;
                }
            }

            if (maxReduction == 0 || bestType == -1) break;
            mentors[bestType]++;
            mentorCnt++;
        }
        
        int totalWait = 0;
        for (int i = 1; i <= k; i++) {
            totalWait += calculate(advice.get(i), mentors[i]);
        }
        return totalWait;
    }
    
    private int calculate(List<Advice> list, int m) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            pq.add(0);
        }
        int waitSum = 0;
        for (Advice a : list) {
            int available = pq.poll();
            int start = Math.max(a.time, available);
            waitSum += start - a.time;
            pq.add(start + a.duration);
        }
        return waitSum;
    }
}