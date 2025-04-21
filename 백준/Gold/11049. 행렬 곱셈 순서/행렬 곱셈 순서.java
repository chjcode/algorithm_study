import java.io.*;
import java.util.*;

public class Main {

    static class Matrix {
        int r;
        int c;

        Matrix(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Matrix[] matrix = new Matrix[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrix[i] = new Matrix(r, c);
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cnt = dp[i][k] + dp[k + 1][j] + matrix[i].r * matrix[k].c * matrix[j].c;
                    dp[i][j] = Math.min(dp[i][j], cnt);
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}
