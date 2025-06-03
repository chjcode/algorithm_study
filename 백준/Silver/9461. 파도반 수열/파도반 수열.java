import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            
            long[] dp = new long[n+1];
            
            if (n == 1) {
                System.out.println(1);
            } else if (n == 2) {
                System.out.println(1);
            } else if (n == 3) {
                System.out.println(1);
            } else if (n == 4) {
                System.out.println(2);
            } else if (n == 5) {
                System.out.println(2);
            } else {
                dp[1] = 1;
                dp[2] = 1;
                dp[3] = 1;
                dp[4] = 2;
                dp[5] = 2;
                for (int i = 6; i < n+1; i++) {
                    dp[i] = dp[i-1] + dp[i-5];
                }
                
                System.out.println(dp[n]);
            }
        }
    }
}