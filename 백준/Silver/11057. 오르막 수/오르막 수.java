import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        //1 : 1,2,3,4,5,6,7,8,9
        //2 : 11,12,13,14,,,19,23,24,25,,,29,...,99
        
        int[][] dp = new int[n+1][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        
        System.out.println(dp[n][0]);
    }
}