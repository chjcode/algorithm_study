import java.util.*;
import java.io.*;

public class Main {

    static class Coin{
        int amount;
        int count;
        Coin(int amount, int count) {
            this.amount = amount;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 0; tc < 3; tc++) {
            int answer = 0;
            int n = Integer.parseInt(br.readLine());
            int total = 0;
            Coin[] coins = new Coin[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int amount = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(amount, count);
                total += amount * count;
            }

            // 짝수일때만 확인
            if (total % 2 == 0) {
                int target = total/2;
                boolean[] dp = new boolean[target+1];
                dp[0] = true;

                for (Coin coin : coins) {
                    for (int price = target; price > -1; price -= 1) {
                        if (dp[price]) {
                            for (int i = 1; i < coin.count + 1; i++) {
                                int temp = price + coin.amount * i;
                                if (target < temp) break;
                                dp[temp] = true;
                            }

                        }
                    }
                }

                if (dp[target]){
                    answer = 1;
                }
            }
            System.out.println(answer);
        }
    }
}
