import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a,b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        
        //(-20,-15) (-18,-13) (-14,-5), (-5,-3);
        
        int end = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (route[0] > end) {
                answer++;
                end = route[1];
            } else {
                end = Math.min(end, route[1]);
            }
        }
        
        
        return answer;
        
    }
}