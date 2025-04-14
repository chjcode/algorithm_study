import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] stairs = new int[n+1];
        
        for (int i = 1; i < n+1; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[n+1];
        dp[1] = stairs[1];
        if (n==1) {
            dp[1] = stairs[1];
        } else if (n == 2) {
            dp[1] = stairs[1];
            dp[2] = stairs[2] + stairs[1];
        } else if (n == 3) {
            dp[1] = stairs[1];
            dp[2] = stairs[2] + stairs[1];
            dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
        } else {
            dp[1] = stairs[1];
            dp[2] = stairs[2] + stairs[1];
            dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
            
            for (int i = 4; i < n+1; i++) {
                dp[i] = Math.max(stairs[i] + stairs[i-1] + dp[i-3], stairs[i] + dp[i-2]);
            }
        }
        
        System.out.println(dp[n]);
    }
    
    
}