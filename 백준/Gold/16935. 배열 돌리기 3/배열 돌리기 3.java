
import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m,R;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				graph[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int r = 0 ; r < R; r++) {
			int num = Integer.parseInt(st.nextToken());
//			int n = graph.length;
//			int m = graph[0].length;
			// 상하 반전
			if (num == 1) {
				graph = operation1(graph);
			}
			// 좌우 반전
			else if (num == 2) {
				graph = operation2(graph);
			}
			// 90도 오른쪽 회전
			else if (num == 3) {
				graph = operation3(graph);
			}
			
			//90도 왼쪽 회전
			else if (num == 4) {
				graph = operation4(graph);
			}
			
			// 5번 연산
			else if (num == 5) {
				graph = operation5(graph);
			}
			else if (num == 6) {
				graph = operation6(graph);
			}
		}
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static int[][] operation1(int[][] graph) {
		
		for(int j = 0; j < m;j++) {
			for(int i = 0; i < n/2;i++) {
				int temp = graph[i][j];
				graph[i][j] = graph[n-i-1][j];
				graph[n-i-1][j] = temp;
			}
		}
		
		return graph;
	}
	
	private static int[][] operation2(int[][] graph) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m/2; j++) {
				int temp = graph[i][j];
				graph[i][j] = graph[i][m-j-1];
				graph[i][m-j-1] = temp;
			}
		}
		return graph;
	}
	
	private static int[][] operation3(int[][] graph) {
		int[][] temp = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[j][n-1-i] = graph[i][j];
			}
		}
		int t = n;
		n = m;
		m = t;
		return temp;
	}
	
	private static int[][] operation4(int[][] graph) {
		int[][] temp = new int[m][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[m-1-j][i] = graph[i][j];
			}
		}
		int t = n;
		n = m;
		m = t;
		return temp;
	}
	
	private static int[][] operation5(int[][] graph) {
		int[][] temp = new int[n][m];

		for (int i = 0; i< n/2; i++) {
			for (int j = 0; j < m/2; j++) {		// 1 <- 4
				temp[i][j] = graph[i+n/2][j];
			}
		}
		for (int i = 0; i < n/2; i++) {
			for (int j = m/2; j < m; j++) {		// 2 <- 1
				temp[i][j] = graph[i][j-m/2];
			}
		}
		for (int i = n/2; i < n; i++) {			// 4 <- 3
			for (int j = 0; j <m/2; j++) {
				temp[i][j] = graph[i][j+m/2];
			}
		}
		for (int i = n/2; i < n; i++) {			// 3 <- 2
			for (int j = m/2; j < m; j++) {
				temp[i][j] = graph[i-n/2][j];
			}
		}
		return temp;
	}
	
	private static int[][] operation6(int[][] graph) {
		int[][] temp = new int[n][m];

		for (int i = 0; i< n/2; i++) {
			for (int j = 0; j < m/2; j++) {		// 1 <- 2
				temp[i][j] = graph[i][j+m/2];
			}
		}
		for (int i = 0; i < n/2; i++) {
			for (int j = m/2; j < m; j++) {		// 2 <- 3
				temp[i][j] = graph[i+n/2][j];
			}
		}
		for (int i = n/2; i < n; i++) {			// 4 <- 1
			for (int j = 0; j <m/2; j++) {
				temp[i][j] = graph[i-n/2][j];
			}
		}
		for (int i = n/2; i < n; i++) {			// 3 <- 4
			for (int j = m/2; j < m; j++) {
				temp[i][j] = graph[i][j-m/2];
			}
		}
		return temp;
	}
}

//6 8 1
//3 2 6 3 1 2 9 7
//9 7 8 2 1 4 5 3
//5 9 2 1 9 6 1 8
//2 1 3 8 6 3 9 2
//1 3 2 8 7 9 2 1
//4 5 1 9 8 2 1 3
//6
