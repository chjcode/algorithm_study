import java.util.*;
import java.io.*;

public class Main {
    
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        // dp[현재 자릿수][마지막 숫자][지금까지 사용한 숫자들의 집합]
        int[][][] dp = new int[n + 1][10][1 << 10];

        // 1자리 계단 수 각 숫자별로 1로 초기화
        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int len = 2; len <= n; len++) { // 자릿수: 2부터 N까지
            for (int num = 0; num <= 9; num++) { // 현재 자릿수에서 올 수 있는 숫자 0~9
                for (int bit = 0; bit < (1 << 10); bit++) { // 이전까지 사용한 숫자의 집합 (bitmask)
                    int newBit = bit | (1 << num); // 현재 숫자(num)를 사용했다고 표시

                    // 계단 수 조건: 이전 숫자가 num - 1일 때 가능
                    if (num > 0) {
                        dp[len][num][newBit] += dp[len - 1][num - 1][bit];
                        dp[len][num][newBit] %= MOD;
                    }

                    // 계단 수 조건: 이전 숫자가 num + 1일 때도 가능
                    if (num < 9) {
                        dp[len][num][newBit] += dp[len - 1][num + 1][bit];
                        dp[len][num][newBit] %= MOD;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[n][i][(1 << 10) - 1]) % MOD;
        }

        System.out.println(answer);
    }
}
