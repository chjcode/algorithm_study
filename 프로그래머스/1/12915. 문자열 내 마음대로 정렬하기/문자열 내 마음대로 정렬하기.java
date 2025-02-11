import java.util.*;

class Solution {
    
    static class Text implements Comparable<Text>{
        String s;
        int idx;
        Text (String s, int idx) {
            this.s = s;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Text t) {
            if (this.s.charAt(this.idx) == t.s.charAt(t.idx)) {
                return this.s.compareTo(t.s);
            }
            
            return this.s.charAt(this.idx) - t.s.charAt(t.idx);
        }
        
    }
    
    public String[] solution(String[] strings, int n) {
        int len = strings.length;
        String[] answer = new String[len];
        
        Text[] text = new Text[len];
        for (int i = 0; i < len; i++) {
            text[i] = new Text(strings[i], n);
        }
        
        Arrays.sort(text);
        
        for (int i = 0; i < len; i++) {
            answer[i] = text[i].s;
        }
        
        
        return answer;
    }
}