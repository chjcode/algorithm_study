import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if (s.charAt(i) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }   
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        if (stack.size() > 0) {
            answer = 0;
        } else {
            answer = 1;
        }

        return answer;
    }
}