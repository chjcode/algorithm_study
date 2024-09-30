import java.util.*;
import java.io.*;

public class Main {
	
	static int n,k,w,v;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n+1][k+1];
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			for (int j = 1; j < k+1; j++) {
				if (w > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w] + v);
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
