import java.util.*;
import java.io.*;

class Main {
    
    static int n,m;
    static int[][] graph;
    static int[][] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        dp = new int[301][301];
        graph = new int[301][301];
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());    // 사탕 바구니 개수
        m = Integer.parseInt(st.nextToken());    // 사탕 바구니별 사탕 개수

        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = m;
        }
        
        for (int x = 0; x <= 300; x++) {
            for (int y = 0; y <= 300; y++) {
                if (x == 0 && y == 0) continue;
                
                if (y > 0) {
                    dp[x][y] = Math.max(dp[x][y], dp[x][y-1]);
                }
                
                if (x > 0) {
                    dp[x][y] = Math.max(dp[x][y], dp[x-1][y]);
                }
                
                if (graph[x][y] > 0) {
                    int time = x + y;
                    int candy = Math.max(0, m-time);
                    dp[x][y] += candy;
                }
            }
        }
        
        System.out.println(dp[300][300]);
    }
}

