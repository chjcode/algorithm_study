import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peekLast() < current) {
                stack.pollLast();
                k--;
            }

            stack.addLast(current);
        }

        // 아직 제거해야 할 개수가 남았다면 뒤에서 제거
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        return sb.toString();
    }
}