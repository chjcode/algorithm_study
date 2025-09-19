import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n+1];
        
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[n+1];
        dp[1] = arr[1];
        if (n==1) {
            dp[1] = arr[1];
        } else if (n == 2) {
            dp[1] = arr[1];
            dp[2] = arr[2] + arr[1];
        } else {
            dp[1] = arr[1];
            dp[2] = arr[2] + arr[1];
            
            for (int i = 3; i < n+1; i++) {
                dp[i] = Math.max(arr[i] + arr[i-1] + dp[i-3], arr[i] + dp[i-2]);
            }
        }
        
        System.out.println(dp[n]);
    }
    
    
}