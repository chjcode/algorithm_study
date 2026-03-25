class Solution {
    public int solution(String s) {
        
        char x = ' ';
        int same = 0;
        int diff = 0;
        int cnt = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (flag) {
                x = s.charAt(i);
                flag = false;
                same = 1;
                diff = 0;
                cnt++;
            } else {
                
                if (s.charAt(i) == x) {
                    same++;
                } else {
                    diff++;  
                }
                
                if (same == diff) {
                    flag = true;
                }
            }
        }
        
        
        return cnt;
    }
}