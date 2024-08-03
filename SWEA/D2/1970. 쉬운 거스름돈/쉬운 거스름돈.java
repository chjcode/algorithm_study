
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] money = {50000,10000,5000,1000,500,100,50,10};
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < t+1; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] answer = new int[8];

            for (int i = 0; i < 8; i++) {
                answer[i] = n/money[i];
                n %= money[i];
            }

            System.out.println("#" + tc);
            for (int i = 0 ; i < 8; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        }
    }
}
