import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m, answer;
    static int[][] graph, visited;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    graph = new int[n][m];
    for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            graph[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    
    visited = new int[n][m];
    visited[0][0] = graph[0][0];
    for (int j = 1; j < m; j++) {
    	visited[0][j] = graph[0][j] + visited[0][j-1];
    }
    
    for (int i = 1; i < n; i++) {
    	int[] temp1 = new int[m];
    	int[] temp2 = new int[m];
    	temp1[0] = graph[i][0] + visited[i-1][0];
    	for (int j = 1; j < m; j++) {
    		temp1[j] = graph[i][j] + Math.max(temp1[j-1], visited[i-1][j]);
    	}
    	temp2[m-1] = graph[i][m-1] + visited[i-1][m-1];
    	for (int j = m-2; j > -1; j--) {
    		temp2[j] = graph[i][j] + Math.max(temp2[j+1], visited[i-1][j]);
    	}
    	for (int j = 0; j < m; j++) {
    		visited[i][j] = Math.max(temp1[j], temp2[j]);
    	}
    }
    System.out.println(visited[n-1][m-1]);
  }
}











