import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {
        // 문자열을 문자 배열로 변환
        char[] list = my_string.toCharArray();
        
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            
            // 주어진 범위 [s, e]를 뒤집기
            while (s < e) {
                char temp = list[s];
                list[s] = list[e];
                list[e] = temp;
                s++;
                e--;
            }
        }
        
        // 문자 배열을 문자열로 변환하여 반환
        return new String(list);
    }
}