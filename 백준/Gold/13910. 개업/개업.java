import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] woks = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            woks[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] can = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = woks[i];
            if (x <= n) can[x] = true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int sum = woks[i] + woks[j];
                if (sum <= n) can[sum] = true;
            }
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int size = 1; size <= n; size++) {
            if (!can[size]) continue;

            for (int i = size; i <= n; i++) {
                if (dp[i - size] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - size] + 1);
                }
            }
        }

        int ans = dp[n];
        if (ans == Integer.MAX_VALUE) ans = -1;

        System.out.println(ans);
    }
}
