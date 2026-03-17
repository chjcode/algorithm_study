import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        Arrays.sort(data, (a,b) -> {
            if (a[col-1] == b[col-1]) {
                return b[0] - a[0];
            } else {
                return a[col-1] - b[col-1];
            }
        });
        
        int answer = 0;
        for (int i = row_begin; i < row_end+1; i++) {
            int s_i = 0;
            for (int num : data[i-1]) {
                s_i += (num % i);
            }
            
            answer ^= s_i;
        }
        
        
        
        return answer;
    }
}