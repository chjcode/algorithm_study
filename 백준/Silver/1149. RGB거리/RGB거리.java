import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n][3];
		dp[0][0] = graph[0][0];
		dp[0][1] = graph[0][1];
		dp[0][2] = graph[0][2];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				
				int[] cost = new int[2];
				int idx = 0;
				for (int k = 0; k < 3;k++) {
					if (j!=k) {
						cost[idx++] = dp[i-1][k] + graph[i][j];	
					}
				}
				
				
				dp[i][j] = Math.min(cost[0], cost[1]);
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < 3; j++) {
//				System.out.print(dp[i][j] + " ");
//			
//			}
//			System.out.println();
//		}
//		
		
		int answer = Integer.MAX_VALUE;
		for(int j = 0; j < 3; j++) {
			if (dp[n-1][j] < answer) {
				answer = dp[n-1][j];
			}
		}
		
		System.out.println(answer);
		
	}

}
