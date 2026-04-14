import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        Deque<Character> deq = new ArrayDeque<>();

        for (int i = 0; i < number.length(); i++) {
            char now = number.charAt(i);

            while (!deq.isEmpty()) {
                if (k > 0 && deq.peekLast() < now) {
                    deq.pollLast();
                    k--;
                } else {
                    break;
                }
            }

            deq.addLast(now);
        }

        while (k > 0) {
            deq.pollLast();
            k--;
        }

        while (!deq.isEmpty()) {
            sb.append(deq.pollFirst());
        }

        return sb.toString();
    }
}