import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[] order) {
        int n = order.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        int idx = 0;

        for (int box = 1; box <= n; box++) {
            stack.addLast(box);

            while (!stack.isEmpty() && stack.peekLast() == order[idx]) {
                stack.pollLast();
                answer++;
                idx++;
            }
        }

        return answer;
    }
}
