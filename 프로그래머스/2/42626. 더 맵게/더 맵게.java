import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 모든 음식의 스코빌지수를 k 이상으로 만들기 위해
        // 스코빌 지수가 가장 낮은 두 개의 음식을 섞어서 음식을 만든다.
        // 결과 = 가장 맵지 않은 음식의 스코빌 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        while (!pq.isEmpty() && pq.size() > 1) {
            int food1 = pq.poll();
            if (food1 >= K) {
                break;
            }
            int food2 = pq.poll();
            
            int newFood = food1 + food2 * 2;
            pq.add(newFood);
            answer++;
        }
        
        if (pq.size() == 1) {
            if (pq.poll() < K) {
                answer = -1;
            }
        }
        
        return answer;
    }
}