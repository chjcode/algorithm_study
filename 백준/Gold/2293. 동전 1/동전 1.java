
import java.util.*;
import java.io.*;

public class Main {

    static int n,k;
    static int[] coin, dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[n+1];
        dp = new int[k+1];
        dp[0] = 1;  // 아무 동전도 사용하지 않고 0원을 만드는 경우의 수 1

        for (int i = 1; i < n+1; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = dp[j] + dp[j - coin[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
