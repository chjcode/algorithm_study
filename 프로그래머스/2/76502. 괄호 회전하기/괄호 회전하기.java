import java.util.*;

class Solution {
    
    private static boolean check(int idx, int n, String s) {
        
        Deque<Character> deq = new ArrayDeque<>();
        deq.addLast(s.charAt(idx%n));
        for (int i = idx+1; i < n+idx; i++) {
            char temp = s.charAt(i%n);
            
            if (temp == '{' || temp == '[' || temp == '(') {
                deq.addLast(temp);
            } else {
                if (deq.isEmpty()) return false;
                
                if (temp == '}') {
                if (deq.pollLast() != '{') return false; 
                }
                else if (temp == ']') {
                    if (deq.pollLast() != '[') return false;
                }
                else if (temp == ')') {
                    if (deq.pollLast() != '(') return false;
                }
                
            }

        }
        
        return deq.isEmpty();
    }
    
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (check(i,n,s)) answer++;
        }
        
        return answer;
    }
}