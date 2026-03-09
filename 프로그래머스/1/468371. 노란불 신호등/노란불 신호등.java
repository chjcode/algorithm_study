import java.util.*;
class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        
        
        int lcm = 1;
        for (int[] signal : signals) {
            int cycle = signal[0] + signal[1] + signal[2];

            int a = lcm;
            int b = cycle;

            while (b != 0) {
                int temp = a % b;
                a = b;
                b = temp;
            }

            lcm = lcm / a * cycle;
        }
        
        int idx = 0;
        
        while(idx < lcm) {
            
            boolean flag = false;
            
            for (int[] signal : signals) {
                int green = signal[0];
                int yellow = signal[1];
                int red = signal[2];
                int mod = green + yellow + red;
                if (idx % mod <= (green % mod)) {
                    flag = false;
                    break;
                } else if (idx % mod <= (green + yellow) % mod) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
                
            }
            
            if (flag) {
                answer = idx;
                break;
            }
            
            
            idx++;
        }
        
        
        return answer;
    }
}