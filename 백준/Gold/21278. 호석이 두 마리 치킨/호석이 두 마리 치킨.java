import java.util.*;
import java.io.*;

public class Main {
    
    static List<List<Integer>> graph;
    static final int INF = 1_000_000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        
        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dist[u][v] = 1;
            dist[v][u] = 1;
        }
        
        int answerU = 1;
        int answerV = 2;
        int maxSum = INF;
        
        for (int i = 1; i < n+1; i++) {
            for (int j = i+1; j < n+1; j++) {
                int sum = 0;
                
                for (int k = 1; k < n+1; k++) {
                    int d = Math.min(dist[k][i], dist[k][j]);
                    sum += 2 * d;
                }
                
                if (sum < maxSum) {
                    maxSum = sum;
                    answerU = i;
                    answerV = j;
                }
            }
        }
        
        System.out.println(answerU + " " + answerV + " " + maxSum);
        
    }
}