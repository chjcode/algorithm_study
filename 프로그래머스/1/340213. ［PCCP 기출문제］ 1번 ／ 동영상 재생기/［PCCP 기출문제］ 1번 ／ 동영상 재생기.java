import java.util.*;

class Solution {
    
    public String changeTime(int minute) {
        StringBuilder sb = new StringBuilder();
        
        int h = minute / 60;
        int m = minute % 60;
        
        if (h < 10) {
            sb.append('0');
        }
        sb.append(h);
        
        sb.append(":");
        
        if (m < 10) {
            sb.append('0');
        }
        sb.append(m);
        
        return sb.toString();
    }
    public int changeMinute(String time) {
        String[] s = time.split(":");
        int minute = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        
        return minute;
        
    }
    public int isOpening(int nowMinute, int op_startMin, int op_endMin) {

        if (op_startMin <= nowMinute && nowMinute <= op_endMin) {
            return op_endMin;
        }
        
        return nowMinute;
    }
    
    public int move(int minute, int vidMin, String command) {
        if (command.equals("next")) {
            minute += 10;
            if (minute > vidMin) {
                return vidMin;
            }
            
            return minute;
        }
        if (command.equals("prev")) {
            minute -= 10;
            if (minute < 0) {
                return 0;
            }
            return minute;
        }
        
        return minute;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        // pos : 처음 위치
        // 현재 위치가 오프닝 구간이면 자동으로 op_end로 이동
        int vidMin = changeMinute(video_len);
        int nowMin = changeMinute(pos);
        int op_startMin = changeMinute(op_start);
        int op_endMin = changeMinute(op_end);
        
        nowMin = isOpening(nowMin, op_startMin, op_endMin);
        for (String command : commands) {
            nowMin = move(nowMin, vidMin, command);
            
            nowMin = isOpening(nowMin, op_startMin, op_endMin);
            
        }
        
        
        return changeTime(nowMin);
    }
}