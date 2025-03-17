class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            StringBuilder sb = new StringBuilder();
            int count110 = 0;
            int idx = 0;
            int n = str.length();
            
            while (idx < n) {
                sb.append(str.charAt(idx));
                if (sb.length() >= 3) {
                    int len = sb.length();
                    if (sb.charAt(len - 3) == '1' &&
                        sb.charAt(len - 2) == '1' &&
                        sb.charAt(len - 1) == '0') {
                        sb.delete(len - 3, len);
                        count110++;
                    }
                }
                idx++;
            }
            
            String remaining = sb.toString();
            int pos = remaining.lastIndexOf('0');
            StringBuilder result = new StringBuilder();
            if (pos == -1) {
                for (int j = 0; j < count110; j++) {
                    result.append("110");
                }
                result.append(remaining);
            } else {
                result.append(remaining.substring(0, pos + 1));
                for (int j = 0; j < count110; j++) {
                    result.append("110");
                }
                result.append(remaining.substring(pos + 1));
            }
            
            answer[i] = result.toString();
        }
        
        return answer;
    }
}
