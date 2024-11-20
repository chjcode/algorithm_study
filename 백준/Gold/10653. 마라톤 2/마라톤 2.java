import java.util.*;
import java.io.*;

public class Main {

    static int n,k,x,y;
    static Node[] checkpoint;
    static int[][] dp;

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        checkpoint = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            checkpoint[i] = new Node(x,y);
        }

        dp = new int[n][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= k; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + calDist(checkpoint[i], checkpoint[i+1]));

                for (int skip = 1; skip <= k - j && i + skip + 1 < n; skip++) {
                    dp[i + skip + 1][j + skip] = Math.min(dp[i + skip + 1][j + skip],
                            dp[i][j] + calDist(checkpoint[i], checkpoint[i + skip + 1]));
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j <= k; j++) {
            result = Math.min(result, dp[n - 1][j]);
        }

        System.out.println(result);

    }

    private static int calDist(Node node1, Node node2) {
        return Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y);
    }
}