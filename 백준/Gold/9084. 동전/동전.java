import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] coin = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int target = Integer.parseInt(br.readLine());
            
            int[] dp = new int[target+1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int money = coin[i]; money <= target; money++) {
                    dp[money] += dp[money - coin[i]];
                }
            }
            
            sb.append(dp[target]).append("\n");

        }
        
        System.out.println(sb);
    }
}