import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        int n = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        String[] dp = new String[n+1];

        if (n == 1) {
            System.out.println("SK");
        } else if (n == 2) {
            System.out.println("CY");
        } else if (n == 3) {
            System.out.println("SK");
        } else if (n == 4) {
            System.out.println("SK");
        } else {
            dp[1] = "SK";
            dp[2] = "CY";
            dp[3] = "SK";
            dp[4] = "SK";
            for (int i = 5; i < n+1; i++) {
                if (dp[i - 1].equals("CY") || dp[i - 3].equals("CY") || dp[i - 4].equals("CY")) {
                    dp[i] = "SK";
                } else {
                    dp[i] = "CY";
                }
            }
            System.out.println(dp[n]);
        }

            
        
    }
}

