import java.util.*;
import java.io.*;

public class Main {
    
    public static int n,k,answer;
    public static int[][] graph;
    public static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int c = 0; c < n; c++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    if (graph[a][b] > graph[a][c] + graph[c][b]) {
                        graph[a][b] = graph[a][c] + graph[c][b];
                    }
                }
            }
        }
        
        visited = new boolean[n];
        visited[k] = true;
        answer = Integer.MAX_VALUE;
        dfs(k, 1, 0);
        
        System.out.println(answer);
        
    }
    
    private static void dfs(int now, int depth, int costSum) {
        if (depth == n) {
            answer = Math.min(answer, costSum);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, depth+1, costSum + graph[now][i]);
                visited[i] = false;
            }
        }
    }
}