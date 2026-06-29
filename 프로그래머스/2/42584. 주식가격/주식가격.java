import java.util.*;

class Solution {
    public int[] solution(int[] prices) {

        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> deq = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while(!deq.isEmpty()) {
                
                if (prices[deq.peek()] <= prices[i]) break;
                
                int idx = deq.pop();
                answer[idx] = i - idx;
            }
            
            deq.push(i);
        }
        
        while(!deq.isEmpty()) {
            int idx = deq.pop();
            
            answer[idx] = (n-1) - idx;
        }
        
        
        return answer;
    }
}