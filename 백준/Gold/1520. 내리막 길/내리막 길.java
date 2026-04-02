import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n, m;
    static int[][] arr, dp;
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        
        int answer = dfs(0,0);
        
        System.out.println(answer);
    }
    
    private static int dfs(int x, int y) {
        
        if (x == n-1 && y == m-1) return 1;
        
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        
        dp[x][y] = 0;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;
            
            if (arr[x][y] > arr[nx][ny]) {
                dp[x][y] += dfs(nx, ny);
            }
        }
        
        return dp[x][y];
    }
}