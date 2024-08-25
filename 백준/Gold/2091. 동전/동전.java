
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int[] coins = new int[4];
        coins[0] = Integer.parseInt(st.nextToken());
        coins[1] = Integer.parseInt(st.nextToken());
        coins[2] = Integer.parseInt(st.nextToken());
        coins[3] = Integer.parseInt(st.nextToken());

        int[] value = {1, 5, 10, 25};
        int[][] dp = new int[x + 1][5];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int d = 0; d <= Math.min(x, coins[0]); d++) {  // 1센트 처리
            dp[d] = new int[] {d, 0, 0, 0, d};
        }

        for (int i = 1; i < 4; i++) {  // 5센트부터
            for (int j = value[i]; j <= x; j++) {  // 센트 최소값부터 x값까지
                if (dp[j - value[i]][i] + 1 <= coins[i]) {  // 사용가능한 동전개수보다 작거나 같은지
                    if (dp[j - value[i]][4] == -1) {  // 현재 동전을 사용할 때, 나머지가 존재하는지
                        continue;  // 안하면 통과
                    }
                    if (dp[j - value[i]][4] + 1 > dp[j][4]) {  // 갱신하는 값이 더 큰지 확인
                        dp[j] = dp[j - value[i]].clone();
                        dp[j][i] += 1;
                        dp[j][4] += 1;
                    }
                }
            }
        }

        if (dp[x][4] == -1) {
            System.out.println("0 0 0 0");
        } else {
            for (int i = 0; i < 4; i++) {
                System.out.print(dp[x][i] + " ");
            }
        }
    }
}
