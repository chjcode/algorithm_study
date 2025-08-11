import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(String begin, String target, String[] words) {
        
        boolean[] used = new boolean[words.length];
        
        answer = Integer.MAX_VALUE;
        dfs(begin, target, words, 0, used);
        
        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        
        return answer;
    }
    
    private static void dfs(String now, String target, String[] words, int cnt, boolean[] used) {
        if (now.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!used[i] && check(now, words[i])) {
                used[i] = true;
                dfs(words[i], target, words, cnt+1, used);
                used[i] = false;
            }
        }
        
    }
    
    private static boolean check(String now, String word) {
        int cnt = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }
        
        if (cnt == 1) {
            return true;
        } else {
            return false;
        }
    }
}