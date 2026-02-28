import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // A나라 미사일 X -> 가로(s,e)
        // 가로 미사일을 세로 미사일 몇 개로 방어할 수 있을지
        
        //이분탐색?
        // 미사일 개수로 이분탐색 돌리고
        // 가로 미사일 다 방어 해내는지 체크
        // 방어 하면 -> 미사일 개수 줄이기
        // 방어 못하면 -> 미사일 개수 늘리기> 미사일 개수 늘리기
        
        // 근데 위치에 따라 미사일을 방어할 수 있는게 달라지잖아.
        // 최적의 위치를 어떻게 찾지? 걍 그리딘가?
        
        Arrays.sort(targets, (a,b) -> Integer.compare(a[1], b[1]));
        
        int now = 0;
        for (int i = 0; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];
            
            if (now <= s) {
                answer++;
                now = e;
            }
        }
        
        return answer;
    }
}