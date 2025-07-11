import java.util.*;
import java.io.*;

public class Main {
    
    static final int INF = 100000000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i < n+1; i ++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            if (u == -1 && v == -1) break;
            
            dist[u][v] = 1;
            dist[v][u] = 1;
        }

        for (int k = 1; k < n+1; k++) {
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int min = INF;
        int[] score = new int[n+1];
        
        for (int i = 1; i < n+1; i++) {
            int max = 0;
            for (int j = 1; j < n+1; j++) {
                max = Math.max(max, dist[i][j]);
            }
            score[i] = max;
            min = Math.min(min, max);
        }
        
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            if (score[i] == min) {
                sb.append(i + " ");
                cnt++;
            }
        }
        
        System.out.println(min + " " + cnt);
        System.out.println(sb.toString().trim());
        
    }
}