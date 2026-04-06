import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        int maxTime = -1;
        m = change(m);
        
        StringBuilder sb;
        
        for (String musicinfo : musicinfos) {
            sb = new StringBuilder();
            
            String[] arr = musicinfo.split(",");
            
            String changeMusic = change(arr[3]);
            int sLen = changeMusic.length();
            int min = calTime(arr[0], arr[1]);
            for (int i = 0; i < min; i++) {
                sb.append(changeMusic.charAt(i%sLen));
            }
            
            String song = sb.toString();
            
            if (song.contains(m)) {
                if (min > maxTime) {
                    maxTime = min;
                    answer = arr[2];
                }
            }
            
        }
        
        return answer;
    }
    
    private int calTime(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");
        
        int sMin = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        int eMin = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
        
        return eMin - sMin;
    }
    
    private String change(String str) {
        return str.replace("C#", "c")
                  .replace("D#", "d")
                  .replace("F#", "f")
                  .replace("G#", "g")
                  .replace("A#", "a");
    }
}