import java.util.*;
import java.io.*;

public class Main {

	static int n,m,a,b,c;
	static int[][] graph;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					graph[i][j] = 0;
				} else {
					graph[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken());
			graph[a][b] = Math.min(graph[a][b], c);
		}
		
		for (int k = 0; k < n; k++ )
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (graph[i][j] > graph[i][k] + graph[k][j]) {
						if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE ) {
							graph[i][j] = graph[i][k] + graph[k][j];	
						}
					}
				}
			}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == Integer.MAX_VALUE) {
					graph[i][j] = 0;
				}
				
				sb.append(graph[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	}

}
