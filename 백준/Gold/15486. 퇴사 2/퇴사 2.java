import java.util.*;
import java.io.*;

class Main{
    
    static class Sangdam{
        int day;
        int money;
        Sangdam(int day, int money) {
            this.day = day;
            this.money = money;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];
        Sangdam[] sangdam = new Sangdam[n+1];
        
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());    
            int day = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            sangdam[i] = new Sangdam(day, money);
        }
        
        for (int i = 1; i < n+1; i++) {
            dp[i] = Math.max(dp[i], dp[i-1]);
            
            if(i+sangdam[i].day <= n+1) {
                dp[i+sangdam[i].day] = Math.max(dp[i+sangdam[i].day], dp[i] + sangdam[i].money);
            }
            //System.out.println(Arrays.toString(dp));
        }
        
        dp[n+1] = Math.max(dp[n+1], dp[n]);
        
        System.out.println(dp[n+1]);
        
        
        
        
    }
}