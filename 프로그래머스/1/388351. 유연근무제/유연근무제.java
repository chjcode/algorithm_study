import java.util.*;

class Solution {
    
    public boolean check(int schedule, int time) {
        if (time <= schedule) return true;
        
        // schedule 958 time 1008
        
        int sMinute = schedule % 100;
        int sHour = schedule / 100;
        int tMinute = time % 100;
        int tHour = time / 100;
        
        int s = sHour * 60 + sMinute;
        int t = tHour * 60 + tMinute;
        
        return t <= s + 10;
        
    }
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        //상품 받을 인원 수 구하기
        // 10분 늦는건 ㄱㅊ
        
        int n = schedules.length; // 직원 수
        
        int cnt = 0;    // 인원 수 세는 변수
        for (int i = 0; i < n; i++) {
        
            boolean flag = true;
            for (int j = 0; j < 7; j++) {
                int day = (startday + j - 1) % 7 + 1;
                if (day == 6 || day == 7) continue;
                
                // 검사 결과 지각했으면 이 직원은 cnt 생략
                if (!check(schedules[i], timelogs[i][j])) {
                    flag  = false;
                    break;
                }
            }
            
            if (flag) cnt++;
        }
        
        
        
        return cnt;
    }
}

// 5 -> 12 -> 12 % 7 = 5