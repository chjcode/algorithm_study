import java.io.*;
import java.util.*;

public class Solution {
	
	static int n,k,v,c;
	static Stuff[] stuff;
	static int[][] dp;
	
	static class Stuff{
		int v;
		int c;
		Stuff (int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			stuff = new Stuff[n+1];
			for (int i = 1; i < n+1; i++) {
				st = new StringTokenizer(br.readLine());
				v = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				stuff[i] = new Stuff(v,c);
			}
			
			
			dp = new int[n+1][k+1];
			for (int i = 1; i < n+1; i++) {
				for (int j = 1; j < k+1; j++) {
					if (stuff[i].v > j) {
						dp[i][j] = dp[i-1][j];
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stuff[i].v] + stuff[i].c);
					}
				}
			}
			
			
			System.out.println("#" + tc + " " + dp[n][k]);
		}
 		
	}
}
