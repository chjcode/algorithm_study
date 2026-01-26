import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] arr;
    static int n,m;
    static boolean[][][][] visited;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visited = new boolean[n][m][n][m];
        
        int coin1X = -1;
        int coin1Y = -1;
        int coin2X = -1;
        int coin2Y = -1;
        boolean find = false;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
                char c = s.charAt(j);
                arr[i][j] = c;
                if (c == 'o' && !find) {
                    coin1X = i;
                    coin1Y = j;
                    find = true;
                } else if (c == 'o' && find) {
                    coin2X = i;
                    coin2Y = j;
                }
            }
        }
        
        
        dfs(coin1X, coin1Y, coin2X, coin2Y, 0);
        
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        
        System.out.println(answer);
    }
    
    private static void dfs(int c1X, int c1Y, int c2X, int c2Y, int depth) {
        if (depth == 10 || depth >= answer) {
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nc1X = c1X + dx[i];
            int nc1Y = c1Y + dy[i];
            int nc2X = c2X + dx[i];
            int nc2Y = c2Y + dy[i];
            
            boolean c1Out = false;
            boolean c2Out = false;
            if (nc1X < 0 || nc1X > (n-1) || nc1Y < 0 || nc1Y > (m-1)) {
                c1Out = true;
            }
            
            if (nc2X < 0 || nc2X > (n-1) || nc2Y < 0 || nc2Y > (m-1)) {
                c2Out = true;
            }
            
            if (c1Out && c2Out) continue;
            
            if (c1Out ^ c2Out) {
                answer = Math.min(answer, depth+1);
                continue;
            }
            
            if (arr[nc1X][nc1Y] == '#') {
                nc1X = c1X;
                nc1Y = c1Y;
            }
            
            if (arr[nc2X][nc2Y] == '#') {
                nc2X = c2X;
                nc2Y = c2Y;
            }
            
            if (visited[nc1X][nc1Y][nc2X][nc2Y]) {
                continue;
            }
            
            visited[nc1X][nc1Y][nc2X][nc2Y] = true;
            dfs(nc1X, nc1Y, nc2X, nc2Y, depth+1);
            visited[nc1X][nc1Y][nc2X][nc2Y] = false;
            
        }
    }
}