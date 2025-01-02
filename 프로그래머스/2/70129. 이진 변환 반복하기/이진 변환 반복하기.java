import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};

        StringBuilder sb = new StringBuilder();
        int zeroCnt = 0;        
        int cnt = 0;
        while (!s.equals("1")) {
            sb = new StringBuilder();
            cnt++;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    sb.append("1");
                } else {
                    zeroCnt++;
                }
            }
                
            // sb를 string으로 변환 후 그 길이를 이진수로 변환
            int answerLen = sb.toString().length();
            sb = new StringBuilder();
            int temp = answerLen;
            while (temp > 0) {
                int a = temp % 2;
                temp /= 2;
                sb.append(a);
            }
            s = sb.toString();
            StringBuilder rev = new StringBuilder();
            for (int i = s.length()-1; i > -1; i--) {
                rev.append(s.charAt(i));
            }
            s = rev.toString();
            
        }
        
        answer = new int[2];
        answer[0] = cnt;
        answer[1] = zeroCnt;
        
        return answer;
    }
}