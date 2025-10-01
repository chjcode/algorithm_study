import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] profit = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= m; j++) {
                profit[temp][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[m + 1][n + 1];
        
        int[][] path = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) { 
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= j; k++) {
                    int cur = dp[i - 1][j - k] + profit[k][i];

                    if (dp[i][j] < cur) {
                        dp[i][j] = cur;
                        path[i][j] = k;
                    }
                }
            }
        }

        System.out.println(dp[m][n]);

        int[] result = new int[m + 1];
        int remainingMoney = n;
        for (int i = m; i > 0; i--) {
            int invested = path[i][remainingMoney];
            result[i] = invested;
            remainingMoney -= invested;
        }

        
        for (int i = 1; i <= m; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}