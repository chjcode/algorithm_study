import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        
        int box = 1;
        int idx = 0;
        int n = order.length;
        
        while (box <= n) {
            if (box == order[idx]) {
                box++;
                idx++;
            } 
            else {
                stack.push(box);
                box++;
            }
            
            while (!stack.isEmpty() && idx < n && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
            }
        }
        
        return idx;
    }
}