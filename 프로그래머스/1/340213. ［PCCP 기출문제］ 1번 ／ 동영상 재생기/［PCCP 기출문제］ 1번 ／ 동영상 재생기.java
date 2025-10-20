import java.util.*;

class Solution {
    
    static class Time {
        int m;
        int s;
        int vid_endM;
        int vid_endS;
        int op_start_sec;
        int op_end_sec;
        int vid_end_sec;
        Time (int m, int s, int op_startM, int op_startS, int op_endM, int op_endS, int vid_endM, int vid_endS) {
            this.m = m;
            this.s = s;
            this.vid_endM = vid_endM;
            this.vid_endS = vid_endS;
            this.op_start_sec = op_startM * 60 + op_startS;
            this.op_end_sec = op_endM * 60 + op_endS;
            this.vid_end_sec = vid_endM * 60 + vid_endS;
            System.out.println(m + ":" + s);
        }
        
        private String getTime() {
            StringBuilder sb = new StringBuilder();
            String mm = Integer.toString(m);
            String ss = Integer.toString(s);
            if (mm.length() < 2) {
                sb.append('0');
            }
            sb.append(mm).append(':');
            if (ss.length() < 2) {
                sb.append('0');
            }
            sb.append(ss);
            return sb.toString();
        }

        private int getCurrentSeconds() {
            return this.m * 60 + this.s;
        }
        
        private void next() {
            int now = getCurrentSeconds();
            checkOpening(now);
            s += 10;
            if (s >= 60) {
                s %= 60;
                m += 1;
            }
            now = getCurrentSeconds();
            checkOpening(now);
            now = getCurrentSeconds();
            checkVid(now);
            System.out.println(m + ":" + s);
        }
        
        private void prev() {
            
            s -= 10;
            if (s < 0) {
                s = (s + 60);
                m -= 1;
            }
            
            int now = getCurrentSeconds();
            checkOpening(now);
            now = getCurrentSeconds();
            checkVid(now);
            System.out.println(m + ":" + s);
        }
        
        private void checkOpening(int currentSec) {
            if (currentSec >= op_start_sec && currentSec <= op_end_sec) {
                this.m = op_end_sec / 60;
                this.s = op_end_sec % 60;
            }
        }
        
        private void checkVid(int currentSec) {
            
            if (currentSec < 0) {
                setFromSeconds(0);
            } else if (currentSec > vid_end_sec) {
               setFromSeconds(vid_end_sec);
            } else {
                setFromSeconds(currentSec);
            }
        }
        
        private void setFromSeconds(int t) {
            this.m = t / 60;
            this.s = t % 60;
        }
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        StringTokenizer st;
        st = new StringTokenizer(pos, ":");
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(video_len, ":");
        int vid_endM = Integer.parseInt(st.nextToken());
        int vid_endS = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(op_start, ":");
        int op_startM = Integer.parseInt(st.nextToken());
        int op_startS = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(op_end, ":");
        int op_endM = Integer.parseInt(st.nextToken());
        int op_endS = Integer.parseInt(st.nextToken());
        
        
        Time time = new Time(m, s, op_startM, op_startS, op_endM, op_endS, vid_endM, vid_endS);
        
        for (String command : commands) {

            if (command.equals("next")) {
                time.next();
            } else if (command.equals("prev")) {
                time.prev();
            }
            
        }
        
        return time.getTime();
    }
}