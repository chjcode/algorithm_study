import java.util.*;

class Solution {
    
    int answer = 0;
    int n;
    Deque<Character> deq = new ArrayDeque<>();

    public int solution(String s) {
        n = s.length();
        
        for (int i = 0; i < n; i++) {
            deq.addLast(s.charAt(i));
        }
        
        check();
        
        for (int i = 0; i < n - 1; i++) {
            char c = deq.pollFirst();
            deq.addLast(c);
            check();
        }
        
        return answer;
    }
    
    private void check() {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : deq) {
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
            } else {
                if (stack.isEmpty()) return;
                
                char top = stack.peekLast();
                if ((c == ')' && top == '(') ||
                    (c == ']' && top == '[') ||
                    (c == '}' && top == '{')) {
                    stack.pollLast();
                } else {
                    return;
                }
            }
        }
        
        if (stack.isEmpty()) {
            answer++;
        }
    }
}