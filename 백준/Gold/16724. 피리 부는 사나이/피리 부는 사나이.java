import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] status;
    static char[][] graph;
    static int n, m, answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new char[n][m];
        
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j);
            }
        }
        
        status = new int[n][m];
        
        answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (status[i][j] == 0) {
                    dfs(i,j);
                }
            }
        }
        
        System.out.println(answer);
        
    }
    
    private static void dfs(int x, int y) {
        status[x][y] = 1;
        
        char move = graph[x][y];
        int nx = x;
        int ny = y;
        if (move == 'D') {
            nx++;
        } else if (move == 'L') {
            ny--;
        } else if (move == 'R') {
            ny++;
        } else {
            nx--;
        }
        
        if (status[nx][ny] == 0) {
            dfs(nx, ny);
        } else if (status[nx][ny] == 1) {
            answer++;
        }
        
        status[x][y] = 2;
    }
}