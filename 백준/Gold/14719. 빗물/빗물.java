import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static int[][] graph;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < m; j++) {
			int height = Integer.parseInt(st.nextToken());
			for (int i = n-1; i > n-1-height; i--) {
				graph[i][j] = 1;
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(graph[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < n; i++) {
			if (graph[i][0] == 0) {
				int idx = 0;
				while(idx < m) {
					if (graph[i][idx] == 0) {
						graph[i][idx] = 1;
						idx++;
					}else {
						break;
					}
				}
			}
			
			if (graph[i][m-1] == 0) {
				int idx = m-1;
				while (idx > -1) {
					if (graph[i][idx] == 0) {
						graph[i][idx] = 1;
						idx--;
					}else {
						break;
					}
				}
			}
		}
		
//		System.out.println();
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(graph[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 0) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
