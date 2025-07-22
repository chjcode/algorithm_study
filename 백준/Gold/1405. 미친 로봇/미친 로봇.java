import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static double[] dir = new double[4];
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static double answer = 0.0;
    static boolean[][] visited = new boolean[30][30];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //확률을 어떻게 구현하지?
        
        n = Integer.parseInt(st.nextToken());
        dir[0] = Integer.parseInt(st.nextToken()) / 100.0;
        dir[1] = Integer.parseInt(st.nextToken()) / 100.0;
        dir[2] = Integer.parseInt(st.nextToken()) / 100.0;
        dir[3] = Integer.parseInt(st.nextToken()) / 100.0;
        
        visited[14][14] = true;
        dfs(14, 14, 0, 1.0);
        System.out.println(answer);
    }
    
    private static void dfs(int x, int y, int depth, double p) {
        if (depth == n) {
            answer += p;
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth+1, p * dir[i]);
                visited[nx][ny] = false;
            }
        }
    }
}