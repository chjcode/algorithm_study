
import java.util.*;
import java.io.*;

public class Main {

	static int n,m,r;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < r; i++) {
			rotate();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void rotate() {
		int group = Math.min(n, m)/2;
		

		for (int g = 0; g < group; g++) {
			
			int temp = graph[g][g];
			for (int j = g; j < m-1-g; j++) {		//위쪽
				graph[g][j] = graph[g][j+1];
			}
			for (int i = g; i < n-1-g; i++) {		//오른쪽
				graph[i][m-1-g] = graph[i+1][m-1-g];
			}
			for (int j = m-1-g; j > g; j--) {		//아래쪽
				graph[n-1-g][j] = graph[n-1-g][j-1];
			}
			for (int i = n-1-g; i > g; i--) {		//왼쪽
				graph[i][g] = graph[i-1][g];
			}
			graph[g+1][g] = temp;
		}
	}

}

//4 4 1
//1 2 3 4
//5 6 7 8
//9 10 11 12
//13 14 15 16
