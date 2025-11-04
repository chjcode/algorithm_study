import java.util.*;
import java.io.*;

public class Main {
    
    static class Counsel {
        int t;
        int p;
        Counsel(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        Counsel[] counsel = new Counsel[n+2];
        int maxDate = 0;
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            counsel[i] = new Counsel(t,p);
            maxDate = Math.max(maxDate, t);
        }
        
        long[] dp = new long[n+2];
        
        for (int i = 1; i < n+2; i++) {
            dp[i] = Math.max(dp[i], dp[i-1]);
            
            if (i < n+1) {
                int end = i + counsel[i].t;
                if (end < n+2) {
                    dp[end] = Math.max(dp[end], dp[i] + counsel[i].p);
                }
            }
            //System.out.println(Arrays.toString(dp));
            
        }
        
        System.out.println(dp[n+1]);
        
    }
}