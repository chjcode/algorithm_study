import java.util.*;

class Solution {
    static int n;
    static int answer;
    public int solution(int[] numbers, int target) {

        answer = 0;
        n = numbers.length;
        
        dfs(numbers, target, 0,0);
        
        return answer;
    }
    
    private static void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == n) {
            if (target == sum) {
                answer++;
            }
            
            return;
        }
        
        dfs(numbers,target, depth+1, sum+numbers[depth]);
        dfs(numbers, target, depth+1, sum-numbers[depth]);
    }
}