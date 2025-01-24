import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] graph,dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m+1; j++) {
                 graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n+1][m+1];
//        for (int j = 1; j < m; j++) {
//            dp[0][j] = dp[0][j-1] + graph[0][j];
//        }
//        for (int i =1; i < n; i++) {
//            dp[i][0] = dp[i-1][0] + graph[i][0];
//        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                dp[i][j] = graph[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int a = 1; a < n + 1; a++) {
            for (int b = 1; b < m + 1; b++) {
                for (int c = a; c < n + 1; c++) {
                    for (int d = b; d < m + 1; d++) {
                        int sum = dp[c][d] - dp[c][b - 1] - dp[a - 1][d] + dp[a - 1][b - 1];
                        answer = Math.max(sum, answer);
                    }
                }
            }
        }
//
//        for (int i = 0; i < n + 1; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        System.out.println(answer);
    }
}

/**
 * 0   0   0   0    0   0
 * 0   2   5 -16  -38  -61
 * 0   7  16 -27  -72 -120
 * 0 -15 -29 -68 -103 -149
 *
 */