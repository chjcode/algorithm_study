import java.util.*;
import java.io.*;

public class Main {
    static long[] dp = new long[55];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        calculateDP();
        long result = countOnesInRange(B) - countOnesInRange(A - 1);
        System.out.print(result);
    }

    static long countOnesInRange(long n) {
        if (n < 0) return 0; // 음수 범위 예외 처리
        long count = n & 1;  // 마지막 비트 체크
        int size = 64 - Long.numberOfLeadingZeros(n); // 비트 수 계산
        for (int i = size - 1; i > 0; i--) {
            if ((n & (1L << i)) != 0L) {
                count += dp[i - 1] + (n - (1L << i) + 1);
                n -= (1L << i);
            }
        }
        return count;
    }

    static void calculateDP() {
        dp[0] = 1;
        for (int i = 1; i < 55; i++) {
            dp[i] = (dp[i - 1] << 1) + (1L << i);
        }
    }
}