import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] card = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        
        for (int i = 1; i < n+1; i++) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                max = Math.max(max, card[j] + dp[i-j]);
            }
            dp[i] = max;
        }
        System.out.println(dp[n]);
    }
}