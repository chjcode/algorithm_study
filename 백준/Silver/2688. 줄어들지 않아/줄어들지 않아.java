import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        long[][] dp = new long[65][10];
        
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        
        for (int i = 2; i < 65; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }

        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += dp[n][j];
            }
            System.out.println(sum);
        }
    }
}