import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        // 출근 희망 시각과 실제로 출근한 기록을 바탕으로 상품을 받을 직원 수
        // 상품 -> 지각 안한사람 상품
        int answer = 0;
        int n = schedules.length;

        for (int i = 0; i < n; i++) {
            int schedule = schedules[i];
            int minTime = calTimeM(schedule);
            int maxTime = calTimeP(schedule);
            boolean flag = true;
            for (int j = 0; j < 7; j++) {
                int day = (j+startday) % 7;
                if (day == 6 || day == 0) {
                    continue;
                }
                
                if (timelogs[i][j] > maxTime) {
                    System.out.println(timelogs[i][j]);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    private static int calTimeP(int time) {
        int h = time / 100;
        int m = time % 100;
        m += 10;
        if (m >= 60) {
            m -= 60;
            h += 1;
        }
        
        return h*100 + m;
    }
    
    private static int calTimeM(int time) {
        int h = time / 100;
        int m = time % 100;
        m = 10;
        if (m < 0) {
            m += 60;
            h -= 1;
        }
        
        return h*100 + m;
    }
}