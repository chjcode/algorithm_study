import java.util.*;
import java.io.*;

public class Main {
    
    static int MAX = 100000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        int[] items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            Arrays.fill(dist[i], MAX);
            dist[i][i] = 0;
        }
        
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[u][v] = Math.min(dist[u][v], c);
            dist[v][u] = Math.min(dist[v][u], c);
        }
        
        for (int k = 1; k < n+1; k++) {
            for (int i = 1; i < n+1; i++) {
                if (dist[i][k] == MAX) continue;
                for (int j = 1; j < n+1; j++) {
                    if (dist[k][j] == MAX) continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i < n+1; i++) {
            int sum = 0;
            for (int j = 1; j < n+1; j++) {
                if (dist[i][j] < m+1) {
                    sum += items[j];
                }
            }
            
            answer = Math.max(answer, sum);
        }
        
        System.out.println(answer);
        
    }
}